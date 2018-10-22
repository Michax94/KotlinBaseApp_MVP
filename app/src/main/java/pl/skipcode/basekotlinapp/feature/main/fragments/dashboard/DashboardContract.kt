package pl.skipcode.basekotlinapp.feature.main.fragments.dashboard

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface DashboardContract {

    interface View : BaseContract.View{
        fun showMessage(message: Int)
        fun clickLogout()
        fun clickUsername()
        fun updateUsernameUI(username: String)
    }

    interface Presenter : BaseContract.Presenter{
        fun loadUser()
        fun logoutUser()
        fun openAbout()
    }

}