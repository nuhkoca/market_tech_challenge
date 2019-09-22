package com.techchallenge.core.util.ext

import android.widget.ImageView
import androidx.annotation.DrawableRes

fun ImageView.setDrawable(@DrawableRes resId: Int) =
    setImageDrawable(context.getDrawableCompat(resId))
