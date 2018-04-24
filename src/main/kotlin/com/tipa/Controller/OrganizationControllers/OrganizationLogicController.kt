package com.tipa.Controller.OrganizationControllers

import com.tipa.Controller.UserControllers.SaveUserController
import com.tipa.Controller.UserControllers.UserSessionInfo
import com.tipa.Dao.OrganizationDAO
import com.tipa.Util.bodyAs
import com.tipa.Util.prepare
import com.tipa.gson
import org.slf4j.LoggerFactory
import spark.Request
import spark.Response
import java.util.HashMap

internal var logger = LoggerFactory.getLogger(OrganizationLogicController::class.java)

class OrganizationLogicController(){
    companion object {
        fun createOrganization(request: Request,response: Response):Any{
            val organizationInfo = request.bodyAs(OrganizationName::class.java)
            val model = HashMap<String, Any>()
            val idUser = UserSessionInfo.getIdUserSession(request)

            val insertStatus = OrganizationDAO.insertOrganization(organizationInfo.organizationName,idUser) == 1

            model.put("statusInsert" , insertStatus)

            return response.prepare(200, model)
        }

        fun getOrganizations(request:Request,response:Response):Any{
            val model = HashMap<String,Any>()
            val idUser = UserSessionInfo.getIdUserSession(request)
            val lstOrganizations = OrganizationDAO.getOrganizationsOfUser(idUser)

            model.put("organizations",lstOrganizations);
            return response.prepare(200,model)
        }

        fun updateOrganization(request: Request,response: Response):Any{
            val organizationInfo = request.bodyAs(OrganizationUpdate::class.java)
            val model = HashMap<String,Any>()
            val statusUpdate = OrganizationDAO.updateOrganizationName(organizationInfo.organizationId,organizationInfo.organizationName) ==1
            model.put("statusUpdate",statusUpdate)
            return response.prepare(200,model)
        }
    }


}
data class OrganizationName(
        val organizationName: String= ""
)

data class OrganizationUpdate(
        val organizationName: String="",
        val organizationId: Int =-1
)