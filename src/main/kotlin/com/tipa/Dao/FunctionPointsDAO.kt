package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.FunctionPointDTO
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
                        | Error: ${error.printStackTrace()}
                    """.trimMargin())
                }.execute()

        return info
    }

    fun getFunctionPointsById(idProject: UUID):List<FunctionPointDTO>{
        val query = """
            SELECT * FROM Funciones
            WHERE idProyectoRelacion = ?
        """.trimIndent()

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,idProject)
                }.onError{ error ->
                    logger.error("""There was an error retrieving the function points for the project id: ${idProject.toString()}""")
                }.query(FunctionPointDTO)

    }

    fun updateFunctionPoints(fntPoints:List<FunctionPointDTO>):Int{

        val queryBuilder = StringBuilder()

        for (i in 0 until fntPoints.size){
            val fntPointDTO = fntPoints.get(i)
            val strFnPoint = "UPDATE Funciones SET NumeroAtributos = ${fntPointDTO.intAtributes} , NumeroEntidades = ${fntPointDTO.intEntities} , TipoFuncion = '${fntPointDTO.tipoFuncion}' WHERE idFuncion = ${fntPointDTO.intIdFunctionPoint}; \n "
            queryBuilder.append(strFnPoint)
        }

        val query = queryBuilder.toString();
        return Database.Builder()
                .statement(query)
                .onError { error ->
                    logger.error("""There was an error executing update for function points
                        | ERROR: $error
                    """.trimMargin())
                }.execute()
    }


}