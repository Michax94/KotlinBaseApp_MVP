package pl.skipcode.basekotlinapp.feature.main.fragments.about.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_dashboard.*
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseFragment
import pl.skipcode.basekotlinapp.feature.main.fragments.about.AboutContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.DashboardContract
import javax.inject.Inject

class AboutFragment : AboutContract.View, BaseFragment(){

    @Inject
    lateinit var presenter: AboutContract.Presenter

    override val layoutId: Int = R.layout.fragment_about

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}