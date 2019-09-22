package com.techchallenge.core.util.ext

import android.animation.Animator
import android.view.View
import android.view.animation.LinearInterpolator

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

inline fun View.rotate(value: Float, crossinline onAnimationEnd: () -> Unit = {}) {
    animate()
        .rotationBy(value)
        .setInterpolator(LinearInterpolator())
        .setListener(object : Animator.AnimatorListener {
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
                // no-op
            }
        })
    this.invalidate()
}
