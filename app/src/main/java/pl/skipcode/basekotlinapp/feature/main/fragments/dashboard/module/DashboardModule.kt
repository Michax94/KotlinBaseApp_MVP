package pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.presentation.DashboardPresenter
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.ui.DashboardFragment
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.feature.splash.presentation.SplashPresenter
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.services.AuthService
import pl.skipcode.basekotlinapp.utils.network.services.DashboardService
import retrofit2.Retrofit

@Module
class DashboardModule {

    @Provides
    fun provideDashboardService(retrofit: Retrofit): DashboardService =
            retrofit.create(DashboardService::class.java)


    @Provides
    fun providePresenter(
            fragment: DashboardFragment,
            service: DashboardService,
            compositeDisposable: CompositeDisposable,
            configuration: ConfigurationInterface,
            router: MainContract.Router
    ): DashboardContract.Presenter =
            DashboardPresenter(
                    fragment,
                    service,
                    compositeDisposable,
                    configuration,
                    router
            )
}