package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class FunctionPointDTO(
        val tipoFuncion:String = "",
        val intEntities:Int = -1,
        val intAtributes:Int = -1,
        val strProyectId:String = "",
        val intIdFunctionPoint: Int = -1,
        val strFunctionName: String = ""

){
    companion object Instance: Hydratable<FunctionPointDTO> {
        override fun from(row: ResultSetWrapper): FunctionPointDTO {
            val tipoFuncion = row.getString("TipoFuncion")
            val intEntities = row.getInt("NumeroEntidades")
            val intAttributes = row.getInt("NumeroAtributos")
            val strProyectId = row.getUUID("idProyectoRelacion").toString()
            val strFunctionName = row.getString("nombreFuncion")
            val intIdFunctionID = row.getInt("idFuncion")
            return FunctionPointDTO(
                    tipoFuncion = tipoFuncion,
                    intEntities = intEntities,
                    intAtributes = intAttributes ,
                    strProyectId = strProyectId,
                    strFunctionName = strFunctionName,
                    intIdFunctionPoint = intIdFunctionID
            )
        }
    }
}