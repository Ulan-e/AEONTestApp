package com.ulanapp.aeon.di

import com.ulanapp.aeon.data.actions.APILoginAction
import com.ulanapp.aeon.data.actions.APILoginActionImpl
import com.ulanapp.aeon.data.actions.APIPaymentsAction
import com.ulanapp.aeon.data.actions.APIPaymentsActionImpl
import dagger.Binds
import dagger.Module

@Module
abstract class APIActionsModule {

    @Binds
    abstract fun provideLoginActions(apiLoginAction: APILoginActionImpl): APILoginAction

    @Binds
    abstract fun providePaymentsActions(apiPaymentsAction: APIPaymentsActionImpl): APIPaymentsAction
}