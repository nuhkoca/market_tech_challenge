package com.techchallenge.core.util.ext

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator

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

// This is replaced with ObjectAnimator since ObjectAnimator saves its position in recycling.
inline fun View.rotate(
    isClockWise: Boolean,
    crossinline onAnimationEnd: () -> Unit = {},
    crossinline onAnimationStart: () -> Unit = {}
) {
    ObjectAnimator.ofFloat(
        this,
        "rotation",
        if (isClockWise) DEGREE_0 else DEGREE_90,
        if (isClockWise) DEGREE_90 else DEGREE_0
    ).apply {
        duration = DEFAULT_DURATION
        interpolator = DecelerateInterpolator()
        repeatCount = 0
        addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
                // no-op
            }

            override fun onAnimationEnd(p0: Animator?) {
                onAnimationEnd.invoke()
            }

            override fun onAnimationCancel(p0: Animator?) {
                // no-op
            }

            override fun onAnimationStart(p0: Animator?) {
                onAnimationStart.invoke()
            }
        })
        start()
    }
}
