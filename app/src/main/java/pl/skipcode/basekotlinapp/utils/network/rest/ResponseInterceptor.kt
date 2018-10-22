package pl.skipcode.basekotlinapp.utils.network.rest

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import timber.log.Timber
import java.lang.Exception
import java.nio.charset.Charset
import okio.BufferedSource
import pl.skipcode.basekotlinapp.utils.network.errors.ErrorStatus


class ResponseInterceptor(
        private val configuration: ConfigurationInterface
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val response = chain.proceed(request)
        val body = response.body()

        var errorCode = 0
        val errorStatus = response.code()

        if (errorStatus >= 400) {

            if (errorStatus == ErrorStatus.UNAUTHORIZED){
                configuration.authorizationSubject.onNext(5)
            }

            // Only intercept JSON type responses and ignore the rest.
            if (body?.contentType() != null && body.contentType()?.subtype() != null && body.contentType()?.subtype()?.toLowerCase().equals("json")) {
                try {
                    val source = body.source()
                    source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
                    val buffer = source.buffer()
                    val charset = body.contentType()?.charset(Charset.forName("UTF-8"))
                    // Clone the existing buffer is they can only read once so we still want to pass the original one to the chain.
                    val json = buffer.clone().readString(charset)
                    val obj = JsonParser().parse(json)
                    // Capture error code an message.
                    if (obj is JsonElement && obj.asJsonObject.has("message")) {
                        val message = obj.asJsonObject.get("message").asString
                        //todo
                        errorCode = 100
                    }
                } catch (e: Exception) {
                    throw ResponseExeption(errorCode, errorStatus)
                }
            }

            throw ResponseExeption(errorCode, errorStatus)
        }

        return response
    }
}