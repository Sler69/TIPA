package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class RequirementDTO(
        val name:String = "",
        val id:String = ""
){
    companion object Instance: Hydratable<RequirementDTO> {
        override fun from(row: ResultSetWrapper): RequirementDTO {
            val name = row.getString("name")
            val id = row.getUUID("idRequirement").toString()

            return RequirementDTO(
                    name = name,
                    id = id
            )
        }
    }
}