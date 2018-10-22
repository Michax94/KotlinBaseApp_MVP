package pl.skipcode.basekotlinapp.feature.commons.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.commons.BaseContract
import pl.skipcode.basekotlinapp.feature.commons.presentation.BasePresenter
import timber.log.Timber

abstract class BaseFragment: Fragment(){

    abstract val layoutId: Int

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId, container, false)
    }

}