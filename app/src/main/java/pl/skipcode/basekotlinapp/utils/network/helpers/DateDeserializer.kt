package pl.skipcode.basekotlinapp.utils.network.helpers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import pl.skipcode.basekotlinapp.BuildConfig
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date>{

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date? {
        val date = json?.asString
        val formatter = SimpleDateFormat(BuildConfig.DATE_FORMAT, Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("GMT")
        return formatter.parse(date)
    }

}