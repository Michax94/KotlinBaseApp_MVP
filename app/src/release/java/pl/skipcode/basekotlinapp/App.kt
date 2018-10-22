package pl.skipcode.basekotlinapp

import timber.log.Timber

class App : BaseApplication() {

    override fun initTimber() {
        Timber.plant(ReleaseTree())
    }
}