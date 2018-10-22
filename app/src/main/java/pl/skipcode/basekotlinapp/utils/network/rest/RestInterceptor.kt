package pl.skipcode.basekotlinapp.utils.network.rest

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import pl.skipcode.basekotlinapp.BuildConfig
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface

class RestInterceptor(
        private val configuration: ConfigurationInterface
) : Interceptor{

    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
        const val AUTHORIZATION_BEARER = "Bearer "
        const val APP_VERSION_HEADER = "App-Client"
        const val VERSION_HEADER = "Version"
        const val ACCEPT = "Accept"
        const val APP_VERSION = "Android"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest: Request = chain.request()
        val newBuilder: Request.Builder = chain.request()
                        .newBuilder()
                        .addHeader(ACCEPT,  "application/json")
                        .addHeader(APP_VERSION_HEADER,  APP_VERSION)
                        .addHeader(VERSION_HEADER, BuildConfig.VERSION_NAME)
                        .method(originalRequest.method(), originalRequest.body())

        if(configuration.isUserLoggedIn()){
            newBuilder.addHeader(AUTHORIZATION_HEADER,  AUTHORIZATION_BEARER + configuration.userToken)
        }

        return chain.proceed(newBuilder.build())
    }
}