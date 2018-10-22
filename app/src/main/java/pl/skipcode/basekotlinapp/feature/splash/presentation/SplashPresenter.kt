package pl.skipcode.basekotlinapp.feature.splash.presentation

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import timber.log.Timber
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val router: SplashContract.Router,
        private val configuration: ConfigurationInterface,
        private val compositeDisposable: CompositeDisposable
) : SplashContract.Presenter {

    companion object {
        const val TIMEOUT = 1500L
    }

    override fun initialize() = Unit
    override fun clear() = Unit

    override fun visible() {
        compositeDisposable.add(
                Observable.just(Unit)
                        .delay(TIMEOUT, TimeUnit.MILLISECONDS)
                        .subscribe(
                                { navigation() },
                                { Timber.e(it) }
                        )
        )
    }

    override fun hide() {
        compositeDisposable.clear()
    }

    private fun navigation() {
        if (configuration.isUserLoggedIn()) {
            router.goToMainActivity()
        } else {
            router.goToAuthActivity()
        }
    }
}