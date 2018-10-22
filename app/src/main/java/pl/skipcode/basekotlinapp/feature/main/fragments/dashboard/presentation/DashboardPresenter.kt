package pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.skipcode.basekotlinapp.feature.commons.presentation.BasePresenter
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.errors.ErrorHelper
import pl.skipcode.basekotlinapp.utils.network.services.DashboardService
import timber.log.Timber

class DashboardPresenter(
        private val view: DashboardContract.View,
        private val dashboardService: DashboardService,
        private val compositeDisposable: CompositeDisposable,
        private val configuration: ConfigurationInterface,
        private val router: MainContract.Router
) : DashboardContract.Presenter, BasePresenter(compositeDisposable) {

    override fun initialize() {
        loadUser()
    }

    override fun loadUser() {
        val username = configuration.userName

        compositeDisposable.add(
                dashboardService.getUser(username, "K2I0-I5HG-XRQT-WNXG")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe (
                                {
                                    view.updateUsernameUI(it.results[0].username)
                                },
                                {
                                    val error = ErrorHelper().getError(it)
                                    view.showMessage(error.message)
                                    Timber.e("Response fail ${it.localizedMessage}")
                                }
                        ))
    }

    override fun openAbout() {
        router.goToAboutFragment()
    }

    override fun logoutUser() {
        configuration.logout()
        router.goToAuthActivity()
    }

}
