package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class LanguageDTO(
        val id: Int = -1,
        val name:String = "",
        val kloc_low:Int = -1,
        val kloc_medium:Int = -1,
        val kloc_high:Int = -1,
        val kloc_avg:Int = -1

){
    companion object Instance: Hydratable<LanguageDTO> {
        override fun from(row: ResultSetWrapper): LanguageDTO {
            val id = row.getInt("idLenguaje")
            val name = row.getString("nombreLenguaje")
            val kloc_low = row.getInt("KLOC_Low")
            val kloc_medium = row.getInt("KLOC_Median")
            val kloc_high = row.getInt("KLOC_High")
            val kloc_avg = row.getInt("KLOC_High")
            return LanguageDTO(
                    id = id,
                    name = name,
                    kloc_low = kloc_low,
                    kloc_medium = kloc_medium,
                    kloc_high = kloc_high,
                    kloc_avg = kloc_avg
            )
        }
    }
}