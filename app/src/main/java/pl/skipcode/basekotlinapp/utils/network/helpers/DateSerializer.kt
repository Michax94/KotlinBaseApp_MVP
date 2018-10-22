package pl.skipcode.basekotlinapp.utils.network.helpers

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import pl.skipcode.basekotlinapp.BuildConfig
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateSerializer : JsonSerializer<Date> {

    override fun serialize(date: Date?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        val formatter = SimpleDateFormat(BuildConfig.DATE_FORMAT, Locale.getDefault())
        formatter.timeZone = TimeZone.getDefault()
        val dateFormatAsString = formatter.format(date)
        return JsonPrimitive(dateFormatAsString)
    }

}