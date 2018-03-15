package com.tipa.Util.DatabaseUtil

import java.sql.ResultSet
import java.sql.SQLException
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.*

open class ResultSetWrapper(private val results: ResultSet) : Iterable<Map<String, @JvmSuppressWildcards Any>>, ResultSet by results {
    override fun iterator(): Iterator<Map<String, Any>> = object : Iterator<Map<String, Any>> {
        private val meta = results.metaData
        private var hasNext = results.next()

        override fun hasNext() = hasNext

        override fun next(): Map<String, Any> {
            val row = LinkedHashMap<String, Any>()

            for (i in 1..meta.columnCount) {
                val column = meta.getColumnName(i)
                val value = results.getObject(i)
                row.put(column, value as Any)
            }

            hasNext = results.next()

            return row
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(columnIndex: Int) = results.getObject(columnIndex) as T?

    @Suppress("UNCHECKED_CAST")
    fun <T> get(columnName: String) = results.getObject(columnName) as T?

    @Suppress("UNCHECKED_CAST")
    fun <T> getOr(columnIndex: Int, default: T?) = try {
        results.getObject(columnIndex) as T?
    } catch (e: SQLException) {
        default
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getOr(columnName: String, default: T?) = try {
        results.getObject(columnName) as T?
    } catch (e: SQLException) {
        default
    }

    fun getUUID(columnIndex: Int) = results.getString(columnIndex)?.let(UUID::fromString)
    fun getUUID(columnName: String) = results.getString(columnName)?.let(UUID::fromString)

    fun getInstant(columnIndex: Int) = getLocalDateTime(columnIndex)?.toInstant(ZoneOffset.UTC)
    fun getInstant(columnName: String) = getLocalDateTime(columnName)?.toInstant(ZoneOffset.UTC)

    fun getLocalDate(columnIndex: Int) = results.getDate(columnIndex)?.toLocalDate()
    fun getLocalDate(columnName: String) = results.getDate(columnName)?.toLocalDate()

    fun getLocalTime(columnIndex: Int) = results.getTime(columnIndex)?.toLocalTime()
    fun getLocalTime(columnName: String) = results.getTime(columnName)?.toLocalTime()

    fun getLocalDateTime(columnIndex: Int) = results.getTimestamp(columnIndex)?.toLocalDateTime()
    fun getLocalDateTime(columnName: String) = results.getTimestamp(columnName)?.toLocalDateTime()

    fun getZoneId(columnName: String) = results.getString(columnName)?.let {
        ZoneId.of(it)
    }

    fun getZoneId(columnIndex: Int) = results.getString(columnIndex)?.let {
        ZoneId.of(it)
    }

    fun <T : Enum<T>> getEnum(columnName: String, default: T) = results.getString(columnName)?.let {
        try {
            java.lang.Enum.valueOf(default.javaClass, it)
        } catch (e: Exception) {
            default
        }
    } ?: default

    fun <T : Enum<T>> getEnum(columnIndex: Int, default: T) = results.getString(columnIndex)?.let {
        try {
            java.lang.Enum.valueOf(default.javaClass, it)
        } catch (e: Exception) {
            default
        }
    }

    companion object {
        private val LOG_CATEGORY = "resultset_wrapper"
    }
}