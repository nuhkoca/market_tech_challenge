package com.techchallenge.core.util.ext

import com.google.android.material.textfield.TextInputEditText
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable

fun TextInputEditText.observeTextChanges(): Observable<String> {
    return textChanges().distinctUntilChanged().map { it.toString() }
}
