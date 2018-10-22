package pl.skipcode.basekotlinapp.feature.main.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.navigation.MainRouter
import pl.skipcode.basekotlinapp.feature.main.presentation.MainPresenter
import pl.skipcode.basekotlinapp.feature.main.ui.MainActivity
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.services.DashboardService
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelper
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelperInterface
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    fun provideRouter(
            activity: MainActivity
    ): MainContract.Router =
            MainRouter(activity)

    @Provides
    fun providePresenter(
            router: MainContract.Router,
            compositeDisposable: CompositeDisposable,
            configuration: ConfigurationInterface
    ): MainContract.Presenter =
            MainPresenter(
                    router,
                    compositeDisposable,
                    configuration
            )
}