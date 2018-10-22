package pl.skipcode.basekotlinapp.feature.splash.navigation

import android.content.Intent
import pl.skipcode.basekotlinapp.feature.auth.ui.AuthActivity
import pl.skipcode.basekotlinapp.feature.commons.navigation.BaseRouter
import pl.skipcode.basekotlinapp.feature.main.ui.MainActivity
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.feature.splash.ui.SplashActivity

class SplashRouter(
        private val activity: SplashActivity
) : SplashContract.Router, BaseRouter(activity) {

    override fun goToMainActivity() {
        activity.startActivity(MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

    override fun goToAuthActivity() {
        activity.startActivity(AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

}