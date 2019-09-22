package com.techchallenge.core.util.ext

import org.threeten.bp.Month
import org.threeten.bp.format.TextStyle.FULL_STANDALONE
import java.util.Locale

fun String.toMonthName(): String {
    return Month.of(this.toInt()).getDisplayName(FULL_STANDALONE, Locale("tr", "TR", "tr"))
}
