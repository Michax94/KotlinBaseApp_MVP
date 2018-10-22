package pl.skipcode.basekotlinapp.feature.main.presentation

import android.Manifest
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.data.api.auth.LoginResponse
import pl.skipcode.basekotlinapp.data.api.auth.Result
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.feature.auth.presentation.AuthPresenter
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.splash.BaseTest
import pl.skipcode.basekotlinapp.utils.configuration.Configuration
import pl.skipcode.basekotlinapp.utils.network.rest.ResponseExeption
import pl.skipcode.basekotlinapp.utils.network.services.AuthService
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelperInterface

class MainPresenterTest : BaseTest(){

    @Mock
    private lateinit var router: MainContract.Router

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: MainContract.Presenter

    override fun setup(){
        super.setup()
        trampolineRxPlugin()
        presenter = MainPresenter(
                router,
                compositeDisposable,
                configuration
        )
    }

    override fun tearDown(){
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                router,
                compositeDisposable,
                configuration
        )
    }

    @Test
    fun `should logout and start auth activity when auth observable return error`() {
        `when`(configuration.authorizationObservable()).thenReturn(Observable.just(5))

        presenter.initialize()

        Mockito.verify(compositeDisposable, Mockito.times(1)).add(ArgumentMatchers.any())
        Mockito.verify(configuration, Mockito.times(1)).authorizationObservable()
        Mockito.verify(configuration, Mockito.times(1)).logout()
        Mockito.verify(router, Mockito.times(1)).goToAuthActivity()

    }

    @Test
    fun `should clear composite when clear is called`(){
        presenter.clear()
        Mockito.verify(compositeDisposable, Mockito.times(1)).clear()
    }

}