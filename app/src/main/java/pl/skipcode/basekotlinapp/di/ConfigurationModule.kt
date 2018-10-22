package pl.skipcode.basekotlinapp.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.orhanobut.hawk.Hawk
import dagger.Module
import dagger.Provides
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import pl.skipcode.basekotlinapp.utils.configuration.Configuration
import javax.inject.Singleton

@Module
class ConfigurationModule {

    @Singleton
    @Provides
    fun configuration(): ConfigurationInterface =
            Configuration()

}