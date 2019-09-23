package com.techchallenge.core.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.techchallenge.core.R
import com.techchallenge.core.util.ext.withBundle
import dagger.android.support.DaggerDialogFragment
import kotlinx.android.synthetic.main.progress_dialog.tvDialog

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(KEY_TITLE)
        tvDialog.text = title
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
        private const val KEY_TITLE = "Title"

        fun newInstance(title: String): ProgressDialogFragment {
            return ProgressDialogFragment().apply {
                withBundle { putString(KEY_TITLE, title) }
            }
        }
    }
}