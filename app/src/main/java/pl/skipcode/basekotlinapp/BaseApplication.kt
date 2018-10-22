package pl.skipcode.basekotlinapp

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.crashlytics.android.Crashlytics
import com.orhanobut.hawk.Hawk
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import io.fabric.sdk.android.Fabric
import pl.skipcode.basekotlinapp.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject
import timber.log.Timber.DebugTree



abstract class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        Hawk.init(this).build()
        Fabric.with(this, Crashlytics())

        initTimber()
        initDaggerComponent()
    }

    abstract fun initTimber()

    private fun initDaggerComponent() {
        DaggerAppComponent.builder()
                .bindApplication(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
            activityInjector

}