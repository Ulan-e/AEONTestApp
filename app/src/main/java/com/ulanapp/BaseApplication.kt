package com.ulanapp

import com.chibatching.kotpref.Kotpref
import com.ulanapp.aeon.BuildConfig
import com.ulanapp.aeon.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import timber.log.Timber.DebugTree


class BaseApplication : DaggerApplication(){

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}