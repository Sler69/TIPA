package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.UserControllers.UserSessionInfo
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
}