package com.techchallenge.core.util.delegate

import androidx.recyclerview.widget.DiffUtil

class AdapterItemDiffUtil constructor(
    private val oldItem: List<AdapterItem>,
    private val newItem: List<AdapterItem>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItem[oldItemPosition] == newItem[newItemPosition]
    }

    override fun getOldListSize() = oldItem.size

    override fun getNewListSize() = newItem.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItem[oldItemPosition] == newItem[newItemPosition]
}
