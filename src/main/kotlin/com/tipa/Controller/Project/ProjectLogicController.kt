package com.tipa.Controller.Project

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.tipa.Controller.UserControllers.UserSessionInfo
import com.tipa.Dao.*
import com.tipa.Dto.FullRequirementDTO
import com.tipa.Dto.FunctionPointDTO
import com.tipa.Util.bodyAs
import com.tipa.Util.prepare
import com.tipa.configuration
import spark.Request
import spark.Response
import java.io.StringWriter
import java.sql.Date
import java.util.*
import kotlin.collections.HashMap

class ProjectLogicController{
    companion object {
        fun getBaseProyectInfo(request: Request,response: Response):Any{
            val idUser = UserSessionInfo.getIdUserSession(request)
            val modelInfo = HashMap<String,Any>()


            val lstLanguages = LanguageDAO.getLanguagesforView()
            val lstModelos = ModelProgrammingDAO.getModelsforView()
            val lstOrganizations = OrganizationDAO.getOrganizationsOfUser(idUser)

            modelInfo.put("lstLanguages",lstLanguages)
            modelInfo.put("lstModels",lstModelos)
            modelInfo.put("lstOrganizations",lstOrganizations)
            return response.prepare(200,modelInfo)
        }

        fun saveProject(request: Request,response: Response):Any{
            val bodyRequest = request.body().toString()
            val jsonParsingObject = JsonParser()

            //Deserializing the Json Body
            val bodyJsonObject = jsonParsingObject.parse(bodyRequest).asJsonObject
            val prjectName = bodyJsonObject.get("projectName").asString
            val dateProjectInteger = bodyJsonObject.get("dateProject").asLong
            val languageProject = bodyJsonObject.get("languageProject").asInt
            val modelProject = bodyJsonObject.get("modelProject").asInt
            val organizationIdProject = bodyJsonObject.get("organizationProject").asInt
            val prioeProject = bodyJsonObject.get("priceProject").asFloat

            val dateProjectDate = Date(dateProjectInteger);

            val uuidForProject = UUID.randomUUID()
            val insertProjectStatus = ProjectDAO.insertProject(uuidForProject,prjectName,dateProjectDate,prioeProject,organizationIdProject,modelProject,languageProject) ==1

            val functionPointsRaw = bodyJsonObject.getAsJsonArray("lstRequirements")

            val nameRequirements =  HashMap<UUID,String>()

            for(i in 0 until functionPointsRaw.size()){
                val functionPointJSONObject = functionPointsRaw.get(i).asJsonObject
                val name = functionPointJSONObject.get("value").asString
                val uuidRequirement = UUID.randomUUID();
                nameRequirements.put(uuidRequirement,name)
            }

            val insertFunctionPntStatus = RequirementDAO.insertRequirements(nameRequirements,uuidForProject) != 0

            val model = HashMap<String,Any>()

            if(insertFunctionPntStatus && insertProjectStatus){
                model.put("insertStatus",true)
            }else{
                model.put("insertStatus",false)
            }

            return response.prepare(200,model)
        }

        fun getProjectsForUser(request:Request,response: Response):Any{
            val model = HashMap<String,Any>()

            val idUser =UserSessionInfo.getIdUserSession(request)
            val projects = ProjectDAO.getProjectsByUserId(idUser)
            model.put("projects",projects)

            return response.prepare(200,model)
        }

        fun saveScaleFactors(req:Request,resp:Response):Any{
            val scaleFactor = req.bodyAs(ScaleFactors::class.java)
            val projectId = UUID.fromString(scaleFactor.projectId)

            val model = HashMap<String,Any>()
            val insertStatus = ScaleFactorsDAO.saveScaleFactors(scaleFactor) ==1

            ProjectDAO.updateScaleFactorsStatus(projectId)

            model.put("insertStatus",insertStatus)
            return resp.prepare(200,model)

        }

        fun saveEfforMultipliers(req: Request,resp: Response):Any{
            val effortMultipliers= req.bodyAs(EffortMultipliers::class.java)
            val model = HashMap<String,Any>()

            val insertStatus = EffortMultipliersDAO.saveEffortMultipliers(effortMultipliers) == 1
            val projecIdUUID = UUID.fromString(effortMultipliers.projectId)
            ProjectDAO.updateMultipliersStatus(projecIdUUID)
            model.put("insertStatus",insertStatus)
            return resp.prepare(200,model)

        }

        fun getFunctionPoints(req: Request,resp: Response):Any{
            val bodyRequest = req.body().toString()
            val jsonParsingObject = JsonParser()
            val jsonObject = jsonParsingObject.parse(bodyRequest).asJsonObject
            val id = jsonObject.get("projecId").asString
            val uuidValue = UUID.fromString(id)

            val lstRequirements = RequirementDAO.getRequirementsById(uuidValue)
            val model = HashMap<String,Any>()
            model.put("lstRequirements",lstRequirements)
            return resp.prepare(200,model)
        }

        fun saveFunctionPoints(req: Request,resp: Response):Any{
            val bodyRequest = req.body().toString()
            val jsonParsingObject = JsonParser()

            val bodyJsonObject = jsonParsingObject.parse(bodyRequest).asJsonObject
            val lstRequirementsRaw = bodyJsonObject.getAsJsonArray("lstRequirements")
            val idProject = bodyJsonObject.get("idProject").asString
            val projectIdUUID = UUID.fromString(idProject)

            val model = HashMap<String,Any>()

            val lstRequirements= ArrayList<FullRequirementDTO>(lstRequirementsRaw.size())

            for(i in 0 until lstRequirementsRaw.size()){
                val requirementJsonObject = lstRequirementsRaw.get(i).asJsonObject
                val requirementName = requirementJsonObject.get("name").asString
                val requirementIdStirng = requirementJsonObject.get("id").asString

                val fntPointsRequirementRaw = requirementJsonObject.getAsJsonArray("functionPnts");

                var lstFntPoints = ArrayList<FunctionPointDTO>()

                for(i in 0 until fntPointsRequirementRaw.size()){
                    val functionPointJSONObject = fntPointsRequirementRaw.get(i).asJsonObject;
                    val intAttributes = functionPointJSONObject.get("numberOfAttributes").asInt
                    val intEntities = functionPointJSONObject.get("numberOfEntities").asInt
                    val fntPointId = functionPointJSONObject.get("idFunctionPoint").asInt
                    val typeFunction = functionPointJSONObject.get("tipoFuncion").asString

                    val fnPointDTO = FunctionPointDTO(
                            intAtributes = intAttributes,
                            intIdFunctionPoint = fntPointId,
                            intEntities = intEntities,
                            tipoFuncion = typeFunction
                    )
                    lstFntPoints.add(fnPointDTO)
                }

                var requiretementDTO = FullRequirementDTO(
                        id = UUID.fromString(requirementIdStirng),
                        name = requirementName,
                        lstFntPoints = lstFntPoints

                )
                lstRequirements.add(requiretementDTO)

            }
            val insertStatus = FunctionPointsDAO.inserFunctionPointsFromRequirements(lstRequirements) != 0

            ProjectDAO.updateFunctionPointsStatus(projectIdUUID)

            model.put("insertStatus",insertStatus)
            return resp.prepare(200,model)
        }


    }
}

data class ScaleFactors(
    val precedentedness:Float = 0.0F,
    val development:Float = 0.0F,
    val architecture:Float = 0.0F,
    val cohesion:Float = 0.0F ,
    val maturity:Float = 0.0F,
    val projectId:String = ""
)

data class EffortMultipliers(
        val softwareReliability:Float = 0.0F,
        val dataCost:Float = 0.0F,
        val complexity:Float = 0.0F,
        val reusability:Float = 0.0F,
        val documentation:Float = 0.0F,
        val execution:Float = 0.0F,
        val storage:Float = 0.0F,
        val volatility:Float = 0.0F,
        val analyst:Float = 0.0F,
        val programmer:Float = 0.0F,
        val continuity:Float = 0.0F,
        val applicationExp:Float = 0.0F,
        val platformExp:Float = 0.0F,
        val languageExp:Float = 0.0F,
        val useSoftware:Float = 0.0F,
        val multisiteDev:Float = 0.0F,
        val schedule:Float = 0.0F,
        val projectId:String = ""
)