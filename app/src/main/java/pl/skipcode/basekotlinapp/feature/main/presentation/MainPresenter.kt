package pl.skipcode.basekotlinapp.feature.main.presentation

import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.commons.presentation.BasePresenter
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import timber.log.Timber

class MainPresenter(
        private val router: MainContract.Router,
        private val compositeDisposable: CompositeDisposable,
        private val configuration: ConfigurationInterface
) : MainContract.Presenter, BasePresenter(compositeDisposable) {

    override fun initialize() {
        compositeDisposable.add(configuration.authorizationObservable()
                .subscribe {
                    Timber.e("MainPresenter logout")
                    configuration.logout()
                    router.goToAuthActivity()
                })
    }
}