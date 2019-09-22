package com.techchallenge.core.util.ext

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

inline fun <reified T : ViewDataBinding> ViewGroup.bind(@LayoutRes layoutId: Int): T {
    return DataBindingUtil.inflate(context.inflater, layoutId, this, false)
}

inline fun <reified T : ViewDataBinding> T.use(crossinline block: T.() -> Unit = {}) {
    block()
    executePendingBindings()
}

fun <T : ViewDataBinding> View.getBinding() = DataBindingUtil.getBinding<T>(this)
