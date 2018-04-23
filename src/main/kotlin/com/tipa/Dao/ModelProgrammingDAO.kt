package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.ModelProgrammingViewDTO

object ModelProgrammingDAO{
    fun getModelsforView():List<ModelProgrammingViewDTO>{
        val query = """
                SELECT * FROM ModelosDesarollo
            """
        return Database.Builder()
                .statement(query)
                .onError{error ->
                    logger.error("""There wasa an erro on retrivieng the list of Models of development
                        | Error: $error
                    """.trimMargin())
                }.query(ModelProgrammingViewDTO)
    }
}