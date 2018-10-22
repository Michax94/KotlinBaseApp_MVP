package pl.skipcode.basekotlinapp

import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

class App : BaseApplication() {

    override fun onCreate() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        super.onCreate()
    }

    override fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}