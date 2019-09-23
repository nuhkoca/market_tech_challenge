package com.techchallenge.core.util.ext

import org.threeten.bp.Month
import org.threeten.bp.format.TextStyle.FULL_STANDALONE
import java.util.Locale

private const val NON_NUMERIC_REGEX = "[^0-9.,]"

fun String.toMonthName(): String {
    return Month.of(this.toInt()).getDisplayName(FULL_STANDALONE, Locale.getDefault())
}

fun String.removeNonDigitCharacters() = replace(NON_NUMERIC_REGEX.toRegex(), "")
