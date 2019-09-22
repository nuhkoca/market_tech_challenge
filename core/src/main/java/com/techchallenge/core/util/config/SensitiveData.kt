package com.techchallenge.core.util.config

object SensitiveData {
    private const val USERNAME_LIB = "username-lib"
    private const val PASSWORD_LIB = "password-lib"

    init {
        System.loadLibrary(USERNAME_LIB)
        System.loadLibrary(PASSWORD_LIB)
    }

    external fun username(): String

    external fun password(): String
}
