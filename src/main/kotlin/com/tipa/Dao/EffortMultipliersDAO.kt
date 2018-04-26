package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.Project.EffortMultipliers
import java.sql.*
import java.util.*

private val DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
private val DB_USER = "danielsadac@estimator-k"
private val DB_PASSWORD = "Yzy@WJfAh4fmiWpV"
private val DB = "estimator"


object EffortMultipliersDAO{
    fun saveEffortMultipliers(effortMultipliers: EffortMultipliers):Int{
        val uuidProject =  UUID.fromString(effortMultipliers.projectId)
        val query = """INSERT INTO MultiplicadorEsfuerzo (RELY, DATA, CPLX, RUSE, DOCU, TIME, STOR, PVOL, ACAP, PCAP, PCON, APEX, PLEX, LTEX, TOOL, SITE, SCED, EM, idProyectoORela) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"""

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setNextValue(effortMultipliers.softwareReliability)
                    statement.setNextValue(effortMultipliers.dataCost)
                    statement.setNextValue(effortMultipliers.complexity)
                    statement.setNextValue(effortMultipliers.reusability)
                    statement.setNextValue(effortMultipliers.documentation)
                    statement.setNextValue(effortMultipliers.execution)
                    statement.setNextValue(effortMultipliers.storage)
                    statement.setNextValue(effortMultipliers.volatility)
                    statement.setNextValue(effortMultipliers.programmer)
                    statement.setNextValue(effortMultipliers.continuity)
                    statement.setNextValue(effortMultipliers.applicationExp)
                    statement.setNextValue(effortMultipliers.platformExp)
                    statement.setNextValue(effortMultipliers.languageExp)
                    statement.setNextValue(effortMultipliers.useSoftware)
                    statement.setNextValue(effortMultipliers.multisiteDev)
                    statement.setNextValue(effortMultipliers.schedule)
                    statement.setNextValue(0.0f)
                    statement.setNextValue(0.0f)
                    statement.setNextValue(uuidProject)
                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a effort multipliers for project with id: ${effortMultipliers.projectId}
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }

    private fun getDBConnection(): Connection? {

        var dbConnection: Connection? = null

        try {

            Class.forName(DB_DRIVER)

        } catch (e: ClassNotFoundException) {

            println(e.message)

        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlserver://estimator-k.database.windows.net:1433;database=" + DB + ";" +
                    "user=" + DB_USER + ";password=" + DB_PASSWORD + ";" +
                    "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;")

        } catch (e: SQLException) {

            println(e.message)

        }

        return dbConnection

    }
}


//Database.Builder()
//                .statement(query)
//                .preparable { statement ->
//                    statement.setNextValue(effortMultipliers.softwareReliability)
//                    statement.setNextValue(effortMultipliers.dataCost)
//                    statement.setNextValue(effortMultipliers.complexity)
//                    statement.setNextValue(effortMultipliers.reusability)
//                    statement.setNextValue(effortMultipliers.documentation)
//                    statement.setNextValue(effortMultipliers.execution)
//                    statement.setNextValue(effortMultipliers.storage)
//                    statement.setNextValue(effortMultipliers.volatility)
//                    statement.setNextValue(effortMultipliers.programmer)
//                    statement.setNextValue(effortMultipliers.continuity)
//                    statement.setNextValue(effortMultipliers.applicationExp)
//                    statement.setNextValue(effortMultipliers.platformExp)
//                    statement.setNextValue(effortMultipliers.languageExp)
//                    statement.setNextValue(effortMultipliers.useSoftware)
//                    statement.setNextValue(effortMultipliers.multisiteDev)
//                    statement.setNextValue(effortMultipliers.schedule)
//                    statement.setNextValue(0.0f)
//                    statement.setNextValue(uuidProject)
//                }
//                .onError{error ->
//                    logger.error("""There wasa an error on inserting a effort multipliers for project with id: ${effortMultipliers.projectId}
//                        | Error: $error
//                    """.trimMargin())
//                }.execute()