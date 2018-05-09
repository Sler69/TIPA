package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.FullRequirementDTO
import com.tipa.Dto.FunctionPointDTO
import com.tipa.Dto.RequirementDTO
import java.io.StringWriter
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

    fun getFunctionPointsById(idRequirement: UUID):List<FunctionPointDTO>{
        val query = """
            SELECT * FROM Funciones
            WHERE idRequirement = ?
        """.trimIndent()

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,idRequirement)
                }.onError{ error ->
                    logger.error("""There was an error retrieving the function points for the project id: ${idRequirement.toString()}""")
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


    fun inserFunctionPointsFromRequirements(requirements: List<FullRequirementDTO>):Int{

        val stringForQuery = StringBuilder()
        val initialQuery = """
         INSERT INTO Funciones (TipoFuncion, NumeroEntidades, NumeroAtributos, idRequirement) VALUES """
        stringForQuery.append(initialQuery);

        requirements.forEach{requirement ->
            requirement.lstFntPoints.forEach{
                stringForQuery.append("""(?,?,?,?), """)
            }
        }

        stringForQuery.deleteCharAt(stringForQuery.length-2)


        val completeQuery = stringForQuery.toString()

        val info = Database.Builder()
                .statement(completeQuery)
                .preparable { statement ->

                    requirements.forEach{requirement ->
                        requirement.lstFntPoints.forEach{fntPont ->
                            statement.setNextValue(fntPont.tipoFuncion)
                            statement.setNextValue(fntPont.intEntities)
                            statement.setNextValue(fntPont.intAtributes)
                            statement.setNextValue(requirement.id)

                        }
                    }

                }
                .onError{error ->
                    logger.error("""There wasa an error on inserting a project with id:  and organization id:
                        | Error: ${error.printStackTrace()}
                    """.trimMargin())
                }.execute()

        return info
    }

    fun getFunctionPointsOfProject(projectId:UUID):List<FunctionPointDTO>{
        val query = """
            SELECT * FROM Requirements
            INNER JOIN Funciones ON Requirements.idRequirement = Funciones.idRequirement WHERE idProyectRelationShip = ?
        """.trimIndent()

        return  Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setObject(1,projectId)
                }.onError{ error ->
                    logger.error("""There was an error retrieving the function points for the project id: ${projectId.toString()}""")
                }.query(FunctionPointDTO)

    }

}