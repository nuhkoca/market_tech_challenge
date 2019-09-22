package com.techchallenge.core.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.techchallenge.core.R
import dagger.android.support.DaggerDialogFragment

class ProgressDialogFragment : DaggerDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.progress_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        isCancelable = false
        setStyle(STYLE_NORMAL, R.style.Marketim_Dialog)
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (tag != null && tag == TAG) {
            if (manager.findFragmentByTag(tag) == null) {
                super.show(manager, tag)
            }
        } else {
            super.show(manager, tag)
        }
    }

    companion object {
        const val TAG = "ProgressDialogFragment"
    }
}
