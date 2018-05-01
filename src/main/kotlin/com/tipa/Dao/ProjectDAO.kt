package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.UserControllers.UserSessionInfo
import com.tipa.Dto.ProjectsViewDTOs
import java.sql.Date

import java.util.*

object ProjectDAO{
    fun insertProject(idProject: UUID, nameProject:String,dateProject:Date,priceProject:Float,idOrganization:Int,idModelDevelopment:Int,idLanguage:Int):Int{
        val query = """
                INSERT INTO Projects (idProyecto, nombreProy, fechaInicio, precioPesos, idOrganizacion, idModeloDesarollo, idLenguajeProgramacion)
                 VALUES (?,?,?,?,?,?,?)
            """
        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,idProject)
                    statement.setString(2,nameProject)
                    statement.setDate(3,dateProject)
                    statement.setFloat(4,priceProject)
                    statement.setInt(5,idOrganization)
                    statement.setInt(6,idModelDevelopment)
                    statement.setInt(7,idLanguage)
                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a project with id: ${idProject.toString()} and organization id: $idOrganization
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }

    fun getProjectsByUserId(idUser:Int):List<ProjectsViewDTOs>{
        val query = """
                SELECT * FROM Projects
                INNER JOIN Organizations ON Projects.idOrganizacion = Organizations.idOrganization
                WHERE Organizations.idUser = ?
            """
        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setInt(1,idUser)
                }
                .onError{error ->
                    logger.error("""There was an error on retrivieng the projects for userid : $idUser
                        | ERROR: $error
                    """.trimMargin())
                }.query(ProjectsViewDTOs)
    }

    fun updateFunctionPointsStatus(projectId:UUID):Int{
        val query = """
                UPDATE Projects SET fnPointsDone = 1 WHERE idProyecto = ?;
            """

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,projectId)
                }.onError { error ->
                    logger.error("""There was an error updating the function points status for project id : ${projectId.toString()}
                        | ERROR: $error
                    """.trimMargin())
                }.execute()
    }

    fun updateMultipliersStatus(projectId:UUID):Int{
        val query = """
                UPDATE Projects SET multipDone = 1 where idProyecto = ?;
            """

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,projectId)
                }.onError { error ->
                    logger.error("""There was an error updating the multipliers status for project id : ${projectId.toString()}
                        | ERROR: $error
                    """.trimMargin())
                }.execute()
    }

    fun updateScaleFactorsStatus(projectId: UUID):Int{
        val query = """
                UPDATE Projects SET scaleFacDone = 1 where idProyecto = ?
            """

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,projectId)
                }.onError { error ->
                    logger.error("""There was an error updating the scale factors status for project id : ${projectId.toString()}
                        | ERROR: $error
                    """.trimMargin())
                }.execute()
    }
}