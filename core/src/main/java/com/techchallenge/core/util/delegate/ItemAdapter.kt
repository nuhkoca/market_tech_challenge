package com.techchallenge.core.util.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class ItemAdapter @Inject constructor(private val delegateAdapterManager: DelegateAdapterManager) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<AdapterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapterManager.createViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return delegateAdapterManager.getViewType(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return delegateAdapterManager.bindViewHolder(
            getItemViewType(position),
            holder,
            items[position]
        )
    }

    fun add(items: List<AdapterItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun update(newItems: List<AdapterItem>) {
        val diff = DiffUtil.calculateDiff(AdapterItemDiffUtil(items, newItems))
        items.clear()
        items.addAll(newItems)
        diff.dispatchUpdatesTo(this)
    }
}
