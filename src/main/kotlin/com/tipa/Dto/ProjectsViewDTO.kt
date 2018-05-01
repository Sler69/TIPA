package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper
import java.sql.Date

data class ProjectsViewDTOs(
        val idProject:String = "",
        val nameProject:String = "",
        val dateProject:String = "",
        val priceProject: Float = 0.0F,
        val nameOrganization:String ="",
        val fntPointsDone:Int = -1,
        val scaleFactorsDone:Int = -1,
        val multipliersDone:Int = -1
){
    companion object Instance: Hydratable<ProjectsViewDTOs> {
        override fun from(row: ResultSetWrapper): ProjectsViewDTOs {
            val idProject = row.getUUID("idProyecto").toString()
            val nameProject = row.getString("nombreProy")
            val dateProject = row.getDate("fechaInicio").toString()
            val priceProject = row.getFloat("precioPesos")
            val nameOrganization = row.getString("name")
            val fntPointDone = row.getInt("fnPointsDone")
            val multiDone = row.getInt("multipDone")
            val scaleFactorDone = row.getInt("scaleFacDone")

            return ProjectsViewDTOs(
                    idProject = idProject,
                    nameProject = nameProject,
                    dateProject = dateProject,
                    priceProject = priceProject,
                    nameOrganization = nameOrganization,
                    fntPointsDone = fntPointDone,
                    multipliersDone = multiDone,
                    scaleFactorsDone = scaleFactorDone
            )
        }
    }
}