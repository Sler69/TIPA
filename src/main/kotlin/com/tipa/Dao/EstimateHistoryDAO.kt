package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.EstimateHistoryDTO
import com.tipa.Dto.LanguageDTO
import com.tipa.Dto.LanguageViewDTO

object EstimateHistoryDAO{
    fun insertHistoryEstimate(estimateHistory:EstimateHistoryDTO):Int{
        val query = """
                INSERT INTO EstimatesHistory (estimateTeamSize, estimateTime, estimateUFP, estimateLanguage) VALUES (?,?,?,?)
            """
        return Database.Builder()
                .statement(query)
                .preparable {  statement ->
                    statement.setFloat(1,estimateHistory.estimateTeamSize)
                    statement.setFloat(2,estimateHistory.estimateTime)
                    statement.setInt(3,estimateHistory.estimateUFP)
                    statement.setString(4,estimateHistory.estimateLanguage)
                }
                .onError{error ->
                    logger.error("""There was an error inserting an estimate to the history
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }

    fun getOldEstimates(estimateHistory: EstimateHistoryDTO):List<EstimateHistoryDTO>{
        val query = """
            SELECT * FROM EstimatesHistory
            WHERE estimateUFP BETWEEN ? AND ? AND estimateLanguage = ?
            """
        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setInt(1,estimateHistory.estimateUFP-20)
                    statement.setInt(2,estimateHistory.estimateUFP+20)
                    statement.setString(3,estimateHistory.estimateLanguage)
                }
                .onError{error ->
                    logger.error("""There wasa an erro on retrivieng the list history
                        | Error: $error
                    """.trimMargin())
                }.query(EstimateHistoryDTO)
    }
}