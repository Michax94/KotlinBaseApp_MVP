package pl.skipcode.basekotlinapp.utils.configuration

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface ConfigurationInterface {
    fun isUserLoggedIn(): Boolean
    fun logout(): Unit
    var userToken: String?
    var userName: String?

    var authorizationSubject: PublishSubject<Int>
    fun authorizationObservable(): Observable<Int>

}