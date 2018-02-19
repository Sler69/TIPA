package Util

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

class LocalDateSerializer : JsonSerializer<LocalDate> {
    override fun serialize(p0: LocalDate?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
        val zoneId = ZoneId.systemDefault()

        val epoch = p0?.atStartOfDay(zoneId)?.toEpochSecond()

        return JsonPrimitive(epoch)
    }
}

class LocalDateTimeSerializer : JsonSerializer<LocalDateTime> {
    override fun serialize(p0: LocalDateTime?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
        val zoneId = ZoneId.systemDefault()

        val epoch = p0?.atZone(zoneId)?.toEpochSecond()

        return JsonPrimitive(epoch)
    }
}