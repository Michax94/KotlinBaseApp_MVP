package pl.skipcode.basekotlinapp.feature.auth

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface AuthContract {

    interface View : BaseContract.View{
        fun showMessage(message: Int)
        fun clickLogin()
        fun readEtUsername() : String
    }

    interface Router : BaseContract.Router{
        fun goToMainActivity()
    }

    interface Presenter : BaseContract.Presenter{
        fun checkCameraPermission()
        fun validateUsername(): Boolean
        fun callLogin()
    }
}