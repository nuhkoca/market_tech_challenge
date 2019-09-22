package com.techchallenge.core.util.validator

interface Validator<T> {
    fun isValid(input: T): Boolean
}
