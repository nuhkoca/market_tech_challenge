package com.techchallenge.core.util.ext

import androidx.recyclerview.widget.DiffUtil
import com.techchallenge.core.util.delegate.AdapterItem
import com.techchallenge.core.util.delegate.AdapterItemDiffUtil
import com.techchallenge.core.util.delegate.ItemAdapter

fun ItemAdapter.smartBind(
    items: MutableList<AdapterItem>,
    newItems: List<AdapterItem>
) {
    if (items.isNullOrEmpty()) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    } else {
        val diff = DiffUtil.calculateDiff(AdapterItemDiffUtil(items, newItems))
        items.clear()
        items.addAll(newItems)
        diff.dispatchUpdatesTo(this)
    }
}
