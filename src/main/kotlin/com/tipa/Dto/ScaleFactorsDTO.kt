package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class ScaleFactorsDTO(
        val precedentedness:Float = 0.0F,
        val development:Float = 0.0F,
        val architecture:Float = 0.0F,
        val cohesion:Float = 0.0F ,
        val maturity:Float = 0.0F,
        val projectId:String = ""
){
    companion object Instance: Hydratable<ScaleFactorsDTO> {
        override fun from(row: ResultSetWrapper): ScaleFactorsDTO {
            val prec = row.getFloat("PREC")
            val development = row.getFloat("FLEX")
            val architecture = row.getFloat("RESL")
            val cohesion = row.getFloat("TEAM")
            val maturity = row.getFloat("EPML")
            val idProject = row.getUUID("idProyRelacion").toString()

            return ScaleFactorsDTO(
                    precedentedness = prec,
                    development = development,
                    architecture =architecture ,
                    cohesion = cohesion,
                    maturity = maturity ,
                    projectId = idProject
            )
        }
    }
}