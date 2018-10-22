package pl.skipcode.basekotlinapp.feature.auth.navigation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.feature.auth.ui.AuthActivity
import pl.skipcode.basekotlinapp.feature.splash.BaseTest

class AuthRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: AuthActivity

    private lateinit var router: AuthContract.Router

    override fun setup() {
        super.setup()
        router = AuthRouter(
                activity
        )
    }

    override fun tearDown() {
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                activity
        )
    }

    @Test
    fun `should finish activity when finish is called`() {
        router.finish()

        verify(activity, times(1)).finish()
    }
}