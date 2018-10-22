package pl.skipcode.basekotlinapp.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Singleton
    @Provides
    fun provideOkHttpClient(
            @Named("rest") restInterceptor: Interceptor,
            @Named("response") responseInterceptor: Interceptor,
    ): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(restInterceptor)
                    .addInterceptor(responseInterceptor)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .build()

}