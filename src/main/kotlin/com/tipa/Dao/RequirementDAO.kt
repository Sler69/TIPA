package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.FunctionPointDTO
import com.tipa.Dto.RequirementDTO
import java.io.StringWriter
import java.util.*

object RequirementDAO{

    fun insertRequirements(requirements:HashMap<UUID,String>,idProyecto:UUID):Int{

        val stringForQuery = StringWriter()
        val initialQuery = """
         INSERT INTO Requirements (idRequirement, idProyectRelationShip, name)  VALUES """
        stringForQuery.append(initialQuery);

        for(i in 0 until requirements.size-1){
            stringForQuery.append("""(?,?,?), """)
        }
        stringForQuery.append("(?,?,?);")

        val completeQuery = stringForQuery.toString()

        val info = Database.Builder()
                .statement(completeQuery)
                .preparable { statement ->
                    for ((key, value) in requirements) {
                        statement.setNextValue(key)
                        statement.setNextValue(idProyecto)
                        statement.setNextValue(value)
                    }
                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a requirements with  project id: ${idProyecto.toString()}
                        | Error: ${error.printStackTrace()}
                    """.trimMargin())
                }.execute()

        return info;
    }

    fun getRequirementsById(idProject: UUID):List<RequirementDTO>{
        val query = """
            SELECT * FROM Requirements
            WHERE idProyectRelationShip = ?
        """.trimIndent()

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,idProject)
                }.onError{ error ->
                    logger.error("""There was an error retrieving the function points for the project id: ${idProject.toString()}
                        |ERROR : $error
                    """.trimMargin())
                }.query(RequirementDTO)

    }

}