package com.techchallenge.core.util.keyboard

data class KeyboardVisibilityChanged(
    val visible: Boolean,
    val contentHeight: Int,
    val contentHeightBeforeResize: Int
)
