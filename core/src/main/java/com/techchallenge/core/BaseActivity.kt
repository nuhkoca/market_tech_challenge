package com.techchallenge.core

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techchallenge.core.dialog.ProgressDialogFragment
import com.techchallenge.core.util.keyboard.FluidContentResizer
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.toolbar_default.toolbar
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel> : DaggerAppCompatActivity(), BaseView {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    @get:LayoutRes
    abstract val layoutId: Int

    protected val compositeDisposable = CompositeDisposable()

    open val isToolbarEnabled: Boolean
        get() = false

    abstract fun getViewModelClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        viewModel = viewModelFactory.create(getViewModelClass())
        if (isToolbarEnabled) setSupportActionBar(toolbar)
        initView()
        observeViewModel()
        FluidContentResizer.listen(this)
    }

    abstract override fun initView()

    abstract override fun observeViewModel()

    fun showDialog(title: String) {
        if (supportFragmentManager.findFragmentByTag(ProgressDialogFragment.TAG) != null) {
            return
        }

        val dialogFragment = ProgressDialogFragment.newInstance(title)
        dialogFragment.show(supportFragmentManager, ProgressDialogFragment.TAG)
    }

    fun hideDialog() {
        val fragment =
            supportFragmentManager.findFragmentByTag(ProgressDialogFragment.TAG) ?: return

        supportFragmentManager.beginTransaction()
            .remove(fragment)
            .commitAllowingStateLoss()
    }
}
