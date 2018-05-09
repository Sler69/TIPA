package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class ProjectDTO(
        val idProject:String = "",
        val nameProject:String = "",
        val dateProject:String = "",
        val priceProject: Float = 0.0F,
        val fntPointsDone:Int = -1,
        val scaleFactorsDone:Int = -1,
        val multipliersDone:Int = -1,
        val idLanguage: Int = -1,
        val idModelDevelopment:Int = -1
){
    companion object Instance: Hydratable<ProjectDTO> {
        override fun from(row: ResultSetWrapper): ProjectDTO {
            val idProject = row.getUUID("idProyecto").toString()
            val nameProject = row.getString("nombreProy")
            val dateProject = row.getDate("fechaInicio").toString()
            val priceProject = row.getFloat("precioPesos")
            val fntPointDone = row.getInt("fnPointsDone")
            val multiDone = row.getInt("multipDone")
            val scaleFactorDone = row.getInt("scaleFacDone")
            val idLanguage = row.getInt("idLenguajeProgramacion")
            val idModelDevelopment = row.getInt("idModeloDesarollo")

            return ProjectDTO(
                    idProject = idProject,
                    nameProject = nameProject,
                    dateProject = dateProject,
                    priceProject = priceProject,
                    fntPointsDone = fntPointDone,
                    multipliersDone = multiDone,
                    scaleFactorsDone = scaleFactorDone,
                    idLanguage = idLanguage,
                    idModelDevelopment = idModelDevelopment
            )
        }
    }
}