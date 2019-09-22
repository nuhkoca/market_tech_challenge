package com.techchallenge.core.util.ext

import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation

const val DEFAULT_PIVOT_X = 0.5f
const val DEFAULT_PIVOT_Y = 0.5f
const val DEGREE_90 = 90.0f
const val DEGREE_0 = 0.0f
const val DEFAULT_DURATION = 200L

inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

inline fun View.rotate(
    isClockWise: Boolean,
    crossinline onAnimationEnd: () -> Unit = {},
    crossinline onAnimationStart: () -> Unit = {}
) {
    RotateAnimation(
        if (isClockWise) DEGREE_0 else DEGREE_90,
        if (isClockWise) DEGREE_90 else DEGREE_0,
        RELATIVE_TO_SELF,
        DEFAULT_PIVOT_X,
        RELATIVE_TO_SELF,
        DEFAULT_PIVOT_Y
    ).apply {
        interpolator = DecelerateInterpolator()
        repeatCount = 0
        duration = DEFAULT_DURATION
        fillAfter = true
        setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
                // no-op
            }

            override fun onAnimationEnd(p0: Animation?) {
                onAnimationEnd.invoke()
            }

            override fun onAnimationStart(p0: Animation?) {
                onAnimationStart.invoke()
            }
        })
        this@rotate.animation = this
        start()
    }
}
