package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class ModelProgrammingViewDTO(
        val id: Int = -1,
        val name:String = ""

){
    companion object Instance: Hydratable<ModelProgrammingViewDTO> {
        override fun from(row: ResultSetWrapper): ModelProgrammingViewDTO {
            val id = row.getInt("idModelo")
            val name = row.getString("nombreModelo")
            return ModelProgrammingViewDTO(
                    id = id,
                    name = name
            )
        }
    }
}