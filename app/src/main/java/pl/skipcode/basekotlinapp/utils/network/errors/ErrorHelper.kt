package pl.skipcode.basekotlinapp.utils.network.errors

import pl.skipcode.basekotlinapp.utils.network.rest.ResponseExeption

class ErrorHelper {

    fun getError(throwable: Throwable) : ErrorModel{
        return if (throwable is ResponseExeption){
            ErrorModel(throwable.errorStatus, throwable.errorCode, getStatusMessage(throwable.errorStatus))
        }else{
            ErrorModel(ErrorStatus.SERVER_ERROR, ErrorStatus.SERVER_ERROR, getStatusMessage(ErrorStatus.SERVER_ERROR))
        }
    }

    private fun getStatusMessage(status: Int) : Int{
        return when (status) {
            ErrorStatus.SERVER_ERROR -> ErrorMessage.SERVER_ERROR
            ErrorStatus.UNAUTHORIZED -> ErrorMessage.UNAUTHORIZED
            ErrorStatus.NOT_FOUND -> ErrorMessage.NOT_FOUND
            else -> ErrorMessage.SERVER_ERROR
        }
    }

}