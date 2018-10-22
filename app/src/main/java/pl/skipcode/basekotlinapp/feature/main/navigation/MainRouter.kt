package pl.skipcode.basekotlinapp.feature.main.navigation

import android.content.Intent
import pl.skipcode.basekotlinapp.feature.auth.ui.AuthActivity
import pl.skipcode.basekotlinapp.feature.commons.navigation.BaseRouter
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.about.ui.AboutFragment
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.ui.DashboardFragment
import pl.skipcode.basekotlinapp.feature.main.ui.MainActivity
import timber.log.Timber

class MainRouter(
        private val activity: MainActivity
) : MainContract.Router, BaseRouter(activity) {

    override fun goToAuthActivity() {
        activity.startActivity(AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

    override fun goToAboutFragment() {
        activity.addFragment(AboutFragment())
    }
}