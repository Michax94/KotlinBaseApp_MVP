package pl.skipcode.basekotlinapp.feature.auth.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.auth.navigation.AuthRouter
import pl.skipcode.basekotlinapp.feature.auth.presentation.AuthPresenter
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.feature.auth.ui.AuthActivity
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.services.AuthService
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelperInterface
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelper
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun providePermissionsHelper(activity: AuthActivity): PermissionsHelperInterface =
            PermissionsHelper(activity)

    @Provides
    fun provideRouter(
            activity: AuthActivity
    ): AuthContract.Router =
            AuthRouter(activity)

    @Provides
    fun providePresenter(
            activity: AuthActivity,
            router: AuthContract.Router,
            authService: AuthService,
            permissionsHelper: PermissionsHelperInterface,
            compositeDisposable: CompositeDisposable,
            configuration: ConfigurationInterface
    ): AuthContract.Presenter =
            AuthPresenter(
                    activity,
                    router,
                    authService,
                    permissionsHelper,
                    compositeDisposable,
                    configuration
            )

    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
            retrofit.create(AuthService::class.java)
}