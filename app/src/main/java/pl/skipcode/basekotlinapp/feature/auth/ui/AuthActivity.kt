package pl.skipcode.basekotlinapp.feature.auth.ui

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import javax.inject.Inject

class AuthActivity : BaseActivity(), AuthContract.View {

    @Inject
    lateinit var presenter: AuthContract.Presenter

    override val layoutId: Int = R.layout.activity_auth
    override val frameLayoutId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()

        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }

    private fun initViews(){
        btnLogin.setOnClickListener{
            clickLogin()
        }
    }

    override fun clickLogin() {
        if (presenter.validateUsername()) {
            presenter.callLogin()
        }
    }

    override fun readEtUsername(): String {
        return etUsername.text.toString()
    }

    override fun showMessage(message: Int) {
        Toast.makeText(this, getString(message), Toast.LENGTH_SHORT).show()
    }
}