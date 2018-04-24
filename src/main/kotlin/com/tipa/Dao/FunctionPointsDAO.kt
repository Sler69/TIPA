package com.tipa.Dao

import Util.Database.Database
import java.io.StringWriter
import java.sql.Date
import java.util.*


object FunctionPointsDAO{
    fun inserFunctionPoints(idProject: UUID, functionPointsNames:List<String>):Int{
        
        val stringForQuery = StringWriter()
        val initialQuery = """
         INSERT INTO Funciones (TipoFuncion, NumeroEntidades, NumeroAtributos, idProyectoRelacion, nombreFuncion) VALUES """
        stringForQuery.append(initialQuery);

        for(i in 0 until functionPointsNames.size-1){
            stringForQuery.append("""(?,?,?,?,?), """)
        }
        stringForQuery.append("(?,?,?,?,?);")

        val completeQuery = stringForQuery.toString()

        val info = Database.Builder()
                .statement(completeQuery)
                .preparable { statement ->
                    for (i in 0 until functionPointsNames.size){
                        statement.setNextValue( "")
                        statement.setNextValue( 0)
                        statement.setNextValue(0)
                        statement.setNextValue(idProject)
                        statement.setNextValue(functionPointsNames.get(i))
                    }
                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a project with id: ${idProject.toString()} and organization id:
                        | Error: $error
                    """.trimMargin())
                }.execute()

        return info;
    }
}