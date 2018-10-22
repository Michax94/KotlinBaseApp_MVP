package pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_dashboard.*
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.commons.BaseContract
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseFragment
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.DashboardContract
import timber.log.Timber
import javax.inject.Inject

class DashboardFragment : DashboardContract.View, BaseFragment(){

    @Inject
    lateinit var presenter: DashboardContract.Presenter

    override val layoutId: Int = R.layout.fragment_dashboard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }

    private fun initViews(){
        btnLogout.setOnClickListener{
            clickLogout()
        }
        tvUsername.setOnClickListener{
            clickUsername()
        }
    }

    override fun clickLogout() {
        presenter.logoutUser()
    }

    override fun clickUsername() {
        presenter.openAbout()
    }

    override fun updateUsernameUI(username: String) {
        tvUsername.text = username
    }

    override fun showMessage(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_SHORT).show()
    }
}