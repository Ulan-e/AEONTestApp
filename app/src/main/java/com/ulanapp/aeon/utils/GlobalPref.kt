package com.ulanapp.aeon.utils

import com.chibatching.kotpref.KotprefModel

object GlobalPref : KotprefModel(){
    var loggedIn: Boolean by booleanPref(false)
    var token: String by stringPref("")
}