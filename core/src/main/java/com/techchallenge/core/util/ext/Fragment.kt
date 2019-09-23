package com.techchallenge.core.util.ext

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun Fragment.withBundle(crossinline bundle: Bundle.() -> Unit): Bundle? {
    arguments = Bundle().apply(bundle)
    return arguments
}
