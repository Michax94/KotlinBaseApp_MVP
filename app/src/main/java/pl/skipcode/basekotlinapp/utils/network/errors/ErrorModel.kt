package pl.skipcode.basekotlinapp.utils.network.errors

import com.google.gson.annotations.SerializedName

data class ErrorModel(
        var status: Int,
        var code: Int,
        var message: Int
)