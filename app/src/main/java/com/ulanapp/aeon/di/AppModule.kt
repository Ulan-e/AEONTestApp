package com.ulanapp.aeon.di

import android.content.Context
import com.ulanapp.BaseApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun context(application: BaseApplication): Context
}