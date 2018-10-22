package pl.skipcode.basekotlinapp.feature.main.fragments.about.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.about.AboutContract
import pl.skipcode.basekotlinapp.feature.main.fragments.about.presentation.AboutPresenter
import pl.skipcode.basekotlinapp.feature.main.fragments.about.ui.AboutFragment
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.presentation.DashboardPresenter
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.ui.DashboardFragment
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.services.DashboardService
import retrofit2.Retrofit

@Module
class AboutModule {

    @Provides
    fun providePresenter(
            fragment: AboutFragment,
            compositeDisposable: CompositeDisposable
    ): AboutContract.Presenter =
            AboutPresenter(
                    fragment,
                    compositeDisposable
            )
}