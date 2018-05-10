package com.tipa.Controller.Project

import com.tipa.Dao.*
import com.tipa.Dto.EstimateHistoryDTO
import com.tipa.Util.EstimationUtil
import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter
import java.util.*
import java.text.NumberFormat
import java.text.DecimalFormat





class ProjectRenderController {
    companion object {


        fun renderListProyectView(req: Request,resp: Response):String{
            val writer = StringWriter();
            val formTemplate = configuration.getTemplate("templates/Projects/listProjects.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }

        fun renderCreateProyectView(req: Request,resp: Response):String{
            val writer = StringWriter();
            val formTemplate = configuration.getTemplate("templates/Projects/createProject.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }



        fun renderEffortMultipliers(req: Request,resp: Response):String{
            val info = req.params(":id")
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/effortMultipliers.ftl")
            val model = HashMap<String,Any>()
            model.put("projectId",info);
            formTemplate.process(model,writer)
            return writer.toString()
        }

        fun renderScaleFactors(req: Request,resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/scaleFactors.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }

        fun renderFunctionPoints(req: Request,resp: Response):String{
            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/PojectValues/functionPoints.ftl")
            formTemplate.process(null,writer)
            return writer.toString()
        }

        fun getEstimation(req: Request,resp: Response):Any{
            val id = req.params("id");
            val uuidProject = UUID.fromString(id);

            val lstFunctionPoints = FunctionPointsDAO.getFunctionPointsOfProject(uuidProject)
            val scaleFactorsProject = ScaleFactorsDAO.getScaelFactorsForProject(uuidProject).first()
            val multipliersProject = EffortMultipliersDAO.getEffortMultipliersProject(uuidProject).first()


            val projectInfo = ProjectDAO.getProjectbyId(uuidProject)
            val languajes = LanguageDAO.getLanguagesforCalculation(projectInfo.first().idLanguage).first()

            val ufp = EstimationUtil.getUFP(lstFunctionPoints)
            val ksloc = (languajes.kloc_avg * ufp)/1000.00

            val multipplierResult = EstimationUtil.getMultipliersResult(multipliersProject)
            val pm = 2.4 * ksloc * multipplierResult
            val scaleFactorRestult = EstimationUtil.getScaleFactorsResult(scaleFactorsProject)

            val e = 1.05 + (0.01 *scaleFactorRestult )
            val f = 0.38 + (0.2 * (e-1.05))
            val timeDevelopment = 2.5 * Math.pow(pm,f)
            val teamSize = pm/timeDevelopment
            val costTeam = timeDevelopment * 160 * teamSize * projectInfo.first().priceProject

            val formatter = NumberFormat.getCurrencyInstance()
            val df2 = DecimalFormat(".##")
            val costTeamFormat = formatter.format(costTeam)
            val teamSizeFormat = df2.format(teamSize)
            val kslocFormat = df2.format(ksloc)
            val timeFormat = df2.format(timeDevelopment)
            val languageName = languajes.name
            val effortProject = df2.format(pm)

            val model = HashMap<String, Any>()
            model.put("costTeam",costTeamFormat)
            model.put("teamSize",teamSizeFormat)
            model.put("timeProject",timeFormat)
            model.put("ksloc",kslocFormat)
            model.put("esfuerzo",effortProject)
            model.put("languageName",languageName)

            val estimateHistory = EstimateHistoryDTO(
                    estimateUFP = ufp,
                    estimateTime = timeDevelopment.toFloat(),
                    estimateTeamSize = teamSize.toFloat(),
                    estimateLanguage = languageName
            )

            val numberOfRegisters = EstimateHistoryDAO.getOldEstimates(estimateHistory)
            var estimationDeviationTeam = 0.0f
            var estimationDeviationTime = 0.0f
            var foundEstimatesDeviation = false
            if(numberOfRegisters.size>2){
                estimationDeviationTeam = EstimationUtil.getDeviationEstimationTeam(numberOfRegisters)
                estimationDeviationTime = EstimationUtil.getDeviationEstimationTime(numberOfRegisters)
                foundEstimatesDeviation = true
            }

            EstimateHistoryDAO.insertHistoryEstimate(estimateHistory)

            model.put("deviationTime",estimationDeviationTime)
            model.put("deviationTeam",estimationDeviationTeam)
            model.put("foundDeviation",foundEstimatesDeviation)

            val writer = StringWriter()
            val formTemplate = configuration.getTemplate("templates/Projects/estimation.ftl")
            formTemplate.process(model,writer)
            return writer.toString()
        }
    }
}