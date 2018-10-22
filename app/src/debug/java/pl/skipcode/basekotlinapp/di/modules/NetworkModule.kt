package pl.skipcode.basekotlinapp.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.skipcode.basekotlinapp.BuildConfig
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.rest.RestInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Named("HttpLogging")
    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor =
            HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(
            @Named("rest") restInterceptor: Interceptor,
            @Named("response") responseInterceptor: Interceptor,
            @Named("HttpLogging") loggingInterceptor: Interceptor
    ): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(restInterceptor)
                    .addInterceptor(responseInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .build()

}