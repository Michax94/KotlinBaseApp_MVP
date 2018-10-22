package pl.skipcode.basekotlinapp.feature.main.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import android.widget.Toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.ui.DashboardFragment
import javax.inject.Inject

class MainActivity : MainContract.View, BaseActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var presenter: MainContract.Presenter

    override val layoutId: Int = R.layout.activity_main
    override val frameLayoutId: Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()

        initFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }

    private fun initFragment(){
        setFragment(DashboardFragment())
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}