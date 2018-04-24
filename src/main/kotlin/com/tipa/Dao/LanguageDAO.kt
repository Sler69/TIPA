package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.LanguageViewDTO
import com.tipa.Dto.OrganizationDTO

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
}