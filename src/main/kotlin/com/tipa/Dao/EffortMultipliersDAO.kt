package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.Project.EffortMultipliers
import java.sql.*
import java.util.*


object EffortMultipliersDAO{
    fun saveEffortMultipliers(effortMultipliers: EffortMultipliers):Int{
        val uuidProject =  UUID.fromString(effortMultipliers.projectId)
        val query = """INSERT INTO MultiplicadorEsfuerzo (RELY, DATA, CPLX, RUSE, DOCU, TIME, STOR, PVOL, ACAP, PCAP, PCON, APEX, PLEX, LTEX, TOOL, SITE, SCED, EM, idProyectoORela) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"""

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setFloat(1,effortMultipliers.softwareReliability)
                    statement.setFloat(2,effortMultipliers.dataCost)
                    statement.setFloat(3,effortMultipliers.complexity)
                    statement.setFloat(4,effortMultipliers.reusability)
                    statement.setFloat(5,effortMultipliers.documentation)
                    statement.setFloat(6,effortMultipliers.execution)
                    statement.setFloat(7,effortMultipliers.storage)
                    statement.setFloat(8,effortMultipliers.volatility)
                    statement.setFloat(9,effortMultipliers.analyst)
                    statement.setFloat(10,effortMultipliers.programmer)
                    statement.setFloat(11,effortMultipliers.continuity)
                    statement.setFloat(12,effortMultipliers.applicationExp)
                    statement.setFloat(13,effortMultipliers.platformExp)
                    statement.setFloat(14,effortMultipliers.languageExp)
                    statement.setFloat(15,effortMultipliers.useSoftware)
                    statement.setFloat(16,effortMultipliers.multisiteDev)
                    statement.setFloat(17,effortMultipliers.schedule)
                    statement.setFloat(18,0.0f)
                    statement.setObject(19,uuidProject)
                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a effort multipliers for project with id: ${effortMultipliers.projectId}
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }


}
