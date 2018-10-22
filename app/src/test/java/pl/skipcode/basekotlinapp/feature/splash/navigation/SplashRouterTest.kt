package pl.skipcode.basekotlinapp.feature.splash.navigation

import android.content.Intent
import android.os.Parcelable
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import pl.skipcode.basekotlinapp.feature.auth.ui.AuthActivity
import pl.skipcode.basekotlinapp.feature.main.ui.MainActivity
import pl.skipcode.basekotlinapp.feature.splash.BaseTest
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.feature.splash.ui.SplashActivity
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface

class SplashRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: SplashActivity

    @Mock
    private lateinit var configurationInterface: ConfigurationInterface

    private lateinit var router: SplashContract.Router

    override fun setup() {
        super.setup()
        router = SplashRouter(
                activity
        )
    }

    override fun tearDown() {
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                activity,
                configurationInterface
        )
    }

    @Test
    fun `should navigate to auth activity when goToAuthActivity is called`() {
        router.goToAuthActivity()

        verify(activity, times(1)).startActivity(
                AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        verify(activity, times(1)).finish()
    }

    @Test
    fun `should navigate to main activity when goToMainActivity is called`() {
        router.goToMainActivity()

        verify(activity, times(1)).startActivity(
                MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        verify(activity, times(1)).finish()
    }

}
