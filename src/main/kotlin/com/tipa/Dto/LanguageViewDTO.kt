package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class LanguageViewDTO(
        val id: Int = -1,
        val name:String = ""

){
    companion object Instance: Hydratable<LanguageViewDTO> {
        override fun from(row: ResultSetWrapper): LanguageViewDTO {
            val id = row.getInt("idLenguaje")
            val name = row.getString("nombreLenguaje")
            return LanguageViewDTO(
                    id = id,
                    name = name
            )
        }
    }
}