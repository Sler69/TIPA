package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class OrganizationDTO(
    val name:String = "",
    val id:Int = -1,
    val countProject:Int = -1
){
    companion object Instance: Hydratable<OrganizationDTO> {
        override fun from(row: ResultSetWrapper): OrganizationDTO {
            val name = row.getString("name")
            val id = row.getInt("idOrganization")
            val countProject = row.getInt("cnt")
            return OrganizationDTO(
                    name = name,
                    id =id,
                    countProject = countProject
            )
        }
    }
}