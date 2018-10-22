package pl.skipcode.basekotlinapp.utils.network.services

import io.reactivex.Single
import pl.skipcode.basekotlinapp.data.api.auth.LoginResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthService {

    @GET("q3u20biq")
    fun loginUser(@Query("username") username: String?, @Query("key") key: String):
            Single<LoginResponse>

}