package com.ulanapp

import android.app.Application
import com.chibatching.kotpref.Kotpref

class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
    }
}