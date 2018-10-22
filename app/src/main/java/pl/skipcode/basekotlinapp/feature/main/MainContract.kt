package pl.skipcode.basekotlinapp.feature.main

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface MainContract {

    interface View : BaseContract.View

    interface Router : BaseContract.Router{
        fun goToAuthActivity()
        fun goToAboutFragment()
    }

    interface Presenter : BaseContract.Presenter

}