package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class MultipliersDTO(
        val softwareReliability:Float = 0.0F,
        val dataCost:Float = 0.0F,
        val complexity:Float = 0.0F,
        val reusability:Float = 0.0F,
        val documentation:Float = 0.0F,
        val execution:Float = 0.0F,
        val storage:Float = 0.0F,
        val volatility:Float = 0.0F,
        val analyst:Float = 0.0F,
        val programmer:Float = 0.0F,
        val continuity:Float = 0.0F,
        val applicationExp:Float = 0.0F,
        val platformExp:Float = 0.0F,
        val languageExp:Float = 0.0F,
        val useSoftware:Float = 0.0F,
        val multisiteDev:Float = 0.0F,
        val schedule:Float = 0.0F,
        val projectId:String = ""
){
    companion object Instance: Hydratable<MultipliersDTO> {
        override fun from(row: ResultSetWrapper): MultipliersDTO {
           // INSERT INTO MultiplicadorEsfuerzo (RELY, DATA, CPLX, RUSE, DOCU, TIME, STOR, PVOL, ACAP, PCAP, PCON, APEX, PLEX, LTEX, TOOL, SITE, SCED, EM, idProyectoORela)
            val softwareReliability = row.getFloat("RELY")
            val dataCost = row.getFloat("DATA");
            val complexity = row.getFloat("CPLX")
            val reusability = row.getFloat("RUSE")
            val documentation = row.getFloat("DOCU")
            val execution = row.getFloat("TIME")
            val storage = row.getFloat("STOR")
            val volatility = row.getFloat("PVOL")
            val analyst = row.getFloat("ACAP")
            val programmer = row.getFloat("PCAP")
            val continuity = row.getFloat("PCON")
            val applicationExp = row.getFloat("APEX")
            val platformExp = row.getFloat("PLEX")
            val languageExp = row.getFloat("LTEX")
            val useSoftware = row.getFloat("TOOL")
            val multisiteDev = row.getFloat("SITE")
            val schedule = row.getFloat("EM")

            return MultipliersDTO(
                    softwareReliability = softwareReliability ,
                    dataCost = dataCost,
                    complexity =  complexity ,
                    reusability = reusability,
                    documentation = documentation,
                    execution = execution,
                    storage = storage,
                    volatility = volatility,
                    analyst = analyst,
                    programmer = programmer,
                    continuity = continuity,
                    applicationExp = applicationExp,
                    platformExp = platformExp,
                    languageExp = languageExp,
                    useSoftware = useSoftware,
                    multisiteDev = multisiteDev,
                    schedule = schedule

            )
        }
    }
}
