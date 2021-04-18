package com.ulanapp.aeon.di

import com.ulanapp.aeon.ui.MainActivity
import com.ulanapp.aeon.ui.login.LoginFragment
import com.ulanapp.aeon.ui.payments.PaymentsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun mainActivity(): MainActivity
}

@Module(includes = [APIActionsModule::class])
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector()
    abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector()
    abstract fun paymentsFragment(): PaymentsFragment
}