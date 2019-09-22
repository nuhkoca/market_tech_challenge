package com.techchallenge.core

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.techchallenge.core.util.ext.getBinding

abstract class BaseViewHolder<DB : ViewDataBinding, T : Any>(itemView: View) :
    ViewHolder(itemView) {

    protected var dataBinding: DB? = null

    init {
        dataBinding = itemView.getBinding()
    }

    abstract fun bindTo(item: T)
}
