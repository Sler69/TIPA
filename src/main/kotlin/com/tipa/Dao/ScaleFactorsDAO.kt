package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.Project.ScaleFactors
import com.tipa.Dto.ScaleFactorsDTO
import java.util.*

object ScaleFactorsDAO{
    fun saveScaleFactors(scaleFactors:ScaleFactors):Int{
        val uuidValue =  UUID.fromString(scaleFactors.projectId)
        val query = """
                INSERT INTO ScaleFactor (PREC, FLEX, RESL, TEAM, EPML, SF, idProyRelacion)
                VALUES (?,?,?,?,?,?,?)
            """
        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setFloat(1,scaleFactors.precedentedness)
                    statement.setFloat(2,scaleFactors.development)
                    statement.setFloat(3,scaleFactors.architecture)
                    statement.setFloat(4,scaleFactors.cohesion)
                    statement.setFloat(5,scaleFactors.maturity)
                    statement.setFloat(6,0.0f)
                    statement.setObject(7,uuidValue)

                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a scalefactor for project with id: ${scaleFactors.projectId}
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }

    fun getScaelFactorsForProject(projectId:UUID):List<ScaleFactorsDTO>{
        val query = """
            SELECT * FROM ScaleFactor
            WHERE idProyRelacion = ?
        """.trimIndent()

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,projectId)
                }
                .onError{error ->
                    logger.error("""There wasa an error on getting a scalefactor for project with id: $projectId
                        | Error: $error ${error.printStackTrace()}
                    """.trimMargin())
                }.query(ScaleFactorsDTO)
    }

}