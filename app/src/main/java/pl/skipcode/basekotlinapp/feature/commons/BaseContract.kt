package pl.skipcode.basekotlinapp.feature.commons

interface BaseContract {

    interface View

    interface Router {
        fun finish()
        fun goToSplashActivity()
    }

    interface Presenter {
        fun initialize()
        fun clear()
    }
}