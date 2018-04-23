package com.tipa.Controller.Project

import com.tipa.Controller.UserControllers.UserSessionInfo
import com.tipa.Dao.LanguageDAO
import com.tipa.Dao.ModelProgrammingDAO
import com.tipa.Dao.OrganizationDAO
import com.tipa.Util.prepare
import spark.Request
import spark.Response

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
    }
}