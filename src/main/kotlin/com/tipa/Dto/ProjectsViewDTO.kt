package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper
import java.sql.Date

data class ProjectsViewDTOs(
        val idProject:String = "",
        val nameProject:String = "",
        val dateProject:String = "",
        val priceProject: Float = 0.0F,
        val nameOrganization:String =""
){
    companion object Instance: Hydratable<ProjectsViewDTOs> {
        override fun from(row: ResultSetWrapper): ProjectsViewDTOs {
            val idProject = row.getUUID("idProyecto").toString()
            val nameProject = row.getString("nombreProy")
            val dateProject = row.getDate("fechaInicio").toString()
            val priceProject = row.getFloat("precioPesos")
            val nameOrganization = row.getString("name")

            return ProjectsViewDTOs(
                    idProject = idProject,
                    nameProject = nameProject,
                    dateProject = dateProject,
                    priceProject = priceProject,
                    nameOrganization = nameOrganization
            )
        }
    }
}