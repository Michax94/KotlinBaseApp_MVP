package pl.skipcode.basekotlinapp.feature.splash

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface SplashContract {

    interface View : BaseContract.View

    interface Router : BaseContract.Router{
        fun goToMainActivity()
        fun goToAuthActivity()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hide()
    }
}