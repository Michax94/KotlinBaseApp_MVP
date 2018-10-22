package pl.skipcode.basekotlinapp.feature.splash.ui

import android.os.Bundle
import android.widget.FrameLayout
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import javax.inject.Inject

class SplashActivity : SplashContract.View, BaseActivity() {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override val layoutId: Int = R.layout.activity_splash
    override val frameLayoutId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.visible()
    }

    override fun onPause() {
        super.onPause()
        presenter.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }


}