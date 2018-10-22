package pl.skipcode.basekotlinapp.feature.splash.presentation

import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import pl.skipcode.basekotlinapp.feature.splash.BaseTest
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface

class SplashPresenterTest : BaseTest() {

    @Mock
    private lateinit var router: SplashContract.Router

    @Mock
    private lateinit var configurationInterface: ConfigurationInterface

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var presenter: SplashContract.Presenter

    override fun setup(){
        super.setup()
        trampolineRxPlugin()
        presenter = SplashPresenter(
                router,
                configurationInterface,
                compositeDisposable
        )
    }

    override fun tearDown(){
        super.tearDown()
        verifyNoMoreInteractions(
                router,
                configurationInterface,
                compositeDisposable
        )
    }

    @Test
    fun `should navigate to auth activity when user is not logged in`() {
        `when`(configurationInterface.isUserLoggedIn()).thenReturn(false)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configurationInterface, times(1)).isUserLoggedIn()
        verify(router, times(1)).goToAuthActivity()
    }

    @Test
    fun `should navigate to main activity when user is logged in`() {
        `when`(configurationInterface.isUserLoggedIn()).thenReturn(true)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configurationInterface, times(1)).isUserLoggedIn()
        verify(router, times(1)).goToMainActivity()
    }

    @Test
    fun `should clear composite disposable when hide is called`() {
        presenter.hide()

        verify(compositeDisposable, times(1)).clear()
    }
}