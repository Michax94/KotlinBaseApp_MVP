package pl.skipcode.basekotlinapp.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import pl.skipcode.basekotlinapp.BuildConfig
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.helpers.DateDeserializer
import pl.skipcode.basekotlinapp.utils.network.helpers.DateSerializer
import pl.skipcode.basekotlinapp.utils.network.rest.ResponseInterceptor
import pl.skipcode.basekotlinapp.utils.network.rest.RestInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class BaseNetworkModule {

    @Named("rest")
    @Provides
    fun provideRestInterceptor(configuration: ConfigurationInterface): Interceptor =
            RestInterceptor(configuration)

    @Named("response")
    @Provides
    fun provideResponseInterceptor(
            configuration: ConfigurationInterface
    ): Interceptor =
            ResponseInterceptor(configuration)

    @Singleton
    @Provides
    fun provideGson(): Gson =
            GsonBuilder()
                    .setDateFormat(BuildConfig.DATE_FORMAT)
                    .registerTypeAdapter(Date::class.java, DateDeserializer())
                    .registerTypeAdapter(Date::class.java, DateSerializer())
                    .serializeNulls()
                    .create()

    @Singleton
    @Provides
    fun provideConverterFactory(gson: Gson): Converter.Factory =
            GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideAdapterFactory(): CallAdapter.Factory =
            RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory,
            callAdapterFactory: CallAdapter.Factory
    ): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BuildConfig.PATH_API)
                    .client(okHttpClient)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .build()

}