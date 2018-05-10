package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class EstimateHistoryDTO(
        val estimateLanguage:String = "",
        val estimateTeamSize:Float = 0.0f,
        val estimateTime:Float = 0.0f,
        val estimateUFP:Int = 0

){
    companion object Instance: Hydratable<EstimateHistoryDTO> {
        override fun from(row: ResultSetWrapper): EstimateHistoryDTO {
            val estimateLanguage = row.getString("estimateLanguage")
            val estimateTeamSize = row.getFloat("estimateTeamSize")
            val estimateUFP = row.getInt("estimateUFP")
            val estimateTime = row.getFloat("estimateTime")
            return EstimateHistoryDTO(
                    estimateLanguage = estimateLanguage,
                    estimateTeamSize = estimateTeamSize,
                    estimateTime = estimateTime ,
                    estimateUFP = estimateUFP
            )
        }
    }
}