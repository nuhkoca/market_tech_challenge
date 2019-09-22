package com.techchallenge.core.util.mapper

interface Mapper<in T, out R> {
    fun invoke(input: T): R
}
