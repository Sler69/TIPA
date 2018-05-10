package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class OrganizationCountDTO(
    val name:String = "",
    val id:Int = -1,
    val countProject:Int = -1
){
    companion object Instance: Hydratable<OrganizationCountDTO> {
        override fun from(row: ResultSetWrapper): OrganizationCountDTO {
            val name = row.getString("name")
            val id = row.getInt("idOrganization")
            var countProject = row.getInt("cnt")
            if(countProject == null) countProject = 0
            return OrganizationCountDTO(
                    name = name,
                    id =id,
                    countProject = countProject
            )
        }
    }
}