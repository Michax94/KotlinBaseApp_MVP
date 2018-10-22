package pl.skipcode.basekotlinapp.feature.auth.navigation

import android.content.Intent
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.feature.auth.ui.AuthActivity
import pl.skipcode.basekotlinapp.feature.commons.navigation.BaseRouter
import pl.skipcode.basekotlinapp.feature.main.ui.MainActivity

class AuthRouter(
        private val activity: AuthActivity
        ) : AuthContract.Router, BaseRouter(activity) {

    override fun goToMainActivity() {
        activity.startActivity(MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }
}