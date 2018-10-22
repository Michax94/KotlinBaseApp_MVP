package pl.skipcode.basekotlinapp.feature.auth.presentation

import android.Manifest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.data.api.auth.LoginResponse
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.rest.*
import pl.skipcode.basekotlinapp.utils.network.services.AuthService
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelperInterface
import timber.log.Timber
import io.reactivex.subscribers.DefaultSubscriber
import pl.skipcode.basekotlinapp.feature.commons.presentation.BasePresenter
import pl.skipcode.basekotlinapp.utils.network.errors.ErrorHelper
import pl.skipcode.basekotlinapp.utils.network.errors.ErrorModel
import java.net.UnknownHostException
import java.util.function.BiConsumer

class AuthPresenter(
        private val view: AuthContract.View,
        private val router: AuthContract.Router,
        private val authService: AuthService,
        private val permissionHelper: PermissionsHelperInterface,
        private val compositeDisposable: CompositeDisposable,
        private val configuration: ConfigurationInterface
) : AuthContract.Presenter, BasePresenter(compositeDisposable) {

    override fun initialize() {
        checkCameraPermission()
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun checkCameraPermission() {
        compositeDisposable.add(
                permissionHelper
                        .request(Manifest.permission.CAMERA)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext{
                            if (!it){
                                router.finish()
                                view.showMessage(R.string.error_permissions_camera)
                            }
                        }
                        .filter{it}
                        .subscribe(
                                { Timber.d("All permissions granted")},
                                { Timber.e(it) }
                        )
        )
    }

    override fun validateUsername(): Boolean {
        val username = view.readEtUsername()

        return when {
            username.isEmpty() -> {
                view.showMessage(R.string.validate_username_empty)
                false
            }
            username.length < 3 -> {
                view.showMessage(R.string.validate_username_too_short)
                false
            }
            else -> true
        }
    }

    override fun callLogin() {
        val username = view.readEtUsername()

        compositeDisposable.add(
                authService.loginUser(username, "K2I0-I5HG-XRQT-WNXG")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe (
                                {
                                    configuration.userToken = it.results[0].token
                                    configuration.userName = it.results[0].username
                                    router.goToMainActivity()
                                },
                                {
                                    val error = ErrorHelper().getError(it)
                                    view.showMessage(error.message)
                                }
                        ))
    }
}