package com.tipa.Util.DatabaseUtil

import java.sql.PreparedStatement

/**
 * A simple delegating, wrapper class for PreparedStatement
 */
class PreparedStatementWrapper(statement: PreparedStatement) : PreparedStatement by statement {
    private var current: Int = 1

    fun setNextValue(item: Any?) = apply {
        setObject(current, item)
        current++
    }
}

fun PreparedStatement.toWrapper() = PreparedStatementWrapper(this)