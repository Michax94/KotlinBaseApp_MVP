package pl.skipcode.basekotlinapp.feature.main.fragments.about.presentation

import android.os.Parcel
import android.os.Parcelable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.skipcode.basekotlinapp.feature.commons.presentation.BasePresenter
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.fragments.about.AboutContract
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.network.errors.ErrorHelper
import pl.skipcode.basekotlinapp.utils.network.services.DashboardService
import timber.log.Timber

class AboutPresenter(
        private val view: AboutContract.View,
        private val compositeDisposable: CompositeDisposable
) : AboutContract.Presenter, BasePresenter(compositeDisposable) {

    override fun initialize() = Unit
}