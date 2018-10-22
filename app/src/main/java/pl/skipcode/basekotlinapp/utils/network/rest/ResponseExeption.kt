package pl.skipcode.basekotlinapp.utils.network.rest

import java.lang.Exception

class ResponseExeption(code : Int, status : Int) : Exception(){

    val errorCode : Int = code
    val errorStatus : Int = status

}