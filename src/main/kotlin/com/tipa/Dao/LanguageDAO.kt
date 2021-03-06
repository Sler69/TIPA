package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.LanguageDTO
import com.tipa.Dto.LanguageViewDTO

object LanguageDAO{
    fun getLanguagesforView():List<LanguageViewDTO>{
        val query = """
                SELECT * FROM Lenguaje
            """
        return Database.Builder()
                .statement(query)
                .onError{error ->
                    logger.error("""There wasa an erro on retrivieng the list of languajes
                        | Error: $error
                    """.trimMargin())
                }.query(LanguageViewDTO)
    }

    fun getLanguagesforCalculation(idLenguaje:Int):List<LanguageDTO>{
        val query = """
                SELECT * FROM Lenguaje
                WHERE idLenguaje = ?
            """
        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setInt(1,idLenguaje)
                }
                .onError{error ->
                    logger.error("""There wasa an erro on retrivieng the list of languajes
                        | Error: $error
                    """.trimMargin())
                }.query(LanguageDTO)
    }
}