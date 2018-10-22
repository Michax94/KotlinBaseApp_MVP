package pl.skipcode.basekotlinapp.feature.splash.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.feature.splash.navigation.SplashRouter
import pl.skipcode.basekotlinapp.feature.splash.presentation.SplashPresenter
import pl.skipcode.basekotlinapp.feature.splash.ui.SplashActivity
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface

@Module
class SplashModule {

    @Provides
    fun provideRouter(
            activity: SplashActivity
    ): SplashContract.Router =
            SplashRouter(
                    activity
            )

    @Provides
    fun providePresenter(
            router: SplashContract.Router,
            configurationInterface: ConfigurationInterface,
            compositeDisposable: CompositeDisposable
    ): SplashContract.Presenter =
            SplashPresenter(
                    router,
                    configurationInterface,
                    compositeDisposable
            )
}