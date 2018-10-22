package pl.skipcode.basekotlinapp.feature.main.fragments.dashboard

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.data.api.auth.LoginResponse
import pl.skipcode.basekotlinapp.data.api.auth.Result
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.presentation.DashboardPresenter
import pl.skipcode.basekotlinapp.feature.main.presentation.MainPresenter
import pl.skipcode.basekotlinapp.feature.splash.BaseTest
import pl.skipcode.basekotlinapp.utils.configuration.Configuration
import pl.skipcode.basekotlinapp.utils.network.rest.ResponseExeption
import pl.skipcode.basekotlinapp.utils.network.services.DashboardService

class DashboardPresenterTest : BaseTest(){

    @Mock
    private lateinit var view: DashboardContract.View

    @Mock
    private lateinit var dashboardService: DashboardService

    @Mock
    private lateinit var routerMain: MainContract.Router

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: DashboardContract.Presenter

    override fun setup(){
        super.setup()
        trampolineRxPlugin()
        presenter = DashboardPresenter(
                view,
                dashboardService,
                compositeDisposable,
                configuration,
                routerMain
        )
    }

    override fun tearDown(){
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                view,
                dashboardService,
                compositeDisposable,
                configuration,
                routerMain
        )
    }

    @Test
    fun `should load username when get user is called`() {
        val username = "user"
        val key = "K2I0-I5HG-XRQT-WNXG"
        val token = "MDQ6VXNlcjEyOTMyMjM2"

        val loginResponseMock = LoginResponse(listOf(Result(username, token)))

        `when`(configuration.userName).thenReturn(username)
        `when`(dashboardService.getUser(username, key)).thenReturn(Single.just(loginResponseMock))

        presenter.initialize()

        verify(configuration, times(1)).userName
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(dashboardService, times(1)).getUser(username, key)
        verify(view, times(1)).updateUsernameUI(username)
    }

    @Test
    fun `should logout and open auth activity when initialize is called and return error 401`() {
        val username = "user"
        val key = "K2I0-I5HG-XRQT-WNXG"

        `when`(configuration.userName).thenReturn(username)
        `when`(dashboardService.getUser(username, key)).thenReturn(Single.error(ResponseExeption(100,401)))

        presenter.initialize()

        verify(configuration, times(1)).userName
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(dashboardService, times(1)).getUser(username, key)
        verify(view, times(1)).showMessage(R.string.error_api_unauthorized)
    }

    @Test
    fun `should logout when logout clicked `() {


        presenter.logoutUser()

        verify(configuration, times(1)).logout()
        verify(routerMain, times(1)).goToAuthActivity()
    }

    @Test
    fun `should clear composite when clear is called`(){
        presenter.clear()
        verify(compositeDisposable, Mockito.times(1)).clear()
    }

}