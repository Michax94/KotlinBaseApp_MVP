package pl.skipcode.basekotlinapp.data.api.auth

import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("results")
        val results: List<Result>)

data class Result(
        @SerializedName("username")
        val username: String,
        @SerializedName("token")
        val token: String
)