package pl.skipcode.basekotlinapp.utils.configuration

import android.content.SharedPreferences
import com.orhanobut.hawk.Hawk
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import pl.skipcode.basekotlinapp.R

class Configuration : ConfigurationInterface {

    companion object {
        const val PREFS_KEY_USERNAME = "UserName"
        const val PREFS_KEY_TOKEN = "UserToken"
    }

    override fun isUserLoggedIn(): Boolean {
        return userToken != null
    }

    override var userToken: String?
        get() = Hawk.get(PREFS_KEY_TOKEN, null)
        set(value) {
            Hawk.put(PREFS_KEY_TOKEN, value)
        }

    override var userName: String?
        get() = Hawk.get(PREFS_KEY_USERNAME, null)
        set(value) {
            Hawk.put(PREFS_KEY_USERNAME, value)
        }

    override fun logout() {
        Hawk.delete(PREFS_KEY_TOKEN)
        Hawk.delete(PREFS_KEY_USERNAME)
    }

    override var authorizationSubject: PublishSubject<Int> = PublishSubject.create<Int>()

    override fun authorizationObservable(): Observable<Int> {
        return authorizationSubject
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}