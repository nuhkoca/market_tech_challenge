package com.techchallenge.marketim.ui.orders

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.techchallenge.core.BaseViewHolder
import com.techchallenge.core.util.delegate.AdapterItem
import com.techchallenge.core.util.delegate.DelegateAdapter
import com.techchallenge.core.util.ext.bind
import com.techchallenge.core.util.ext.isVisible
import com.techchallenge.core.util.ext.rotate
import com.techchallenge.core.util.ext.setDrawable
import com.techchallenge.core.util.ext.toMonthName
import com.techchallenge.core.util.ext.use
import com.techchallenge.core.util.ext.withCurrency
import com.techchallenge.data.ResponseViewItem
import com.techchallenge.marketim.R
import com.techchallenge.marketim.databinding.ViewOrdersLayoutBinding

class OrdersAdapter : DelegateAdapter {

    override fun createViewHolder(parent: ViewGroup): ViewHolder {
        val view = parent.bind<ViewOrdersLayoutBinding>(R.layout.view_orders_layout)
        return OrderViewHolder(view.root)
    }

    override fun bindViewHolder(holder: ViewHolder, item: AdapterItem) {
        holder as OrderViewHolder
        holder.bindTo(item)
    }

    override fun isForViewType(item: AdapterItem) = item is ResponseViewItem

    inner class OrderViewHolder(itemView: View) :
        BaseViewHolder<ViewOrdersLayoutBinding, AdapterItem>(itemView) {
        override fun bindTo(item: AdapterItem) {
            item as ResponseViewItem
            with(item) {
                dataBinding?.use {
                    tvDate.text = date
                    tvMonth.text = month.toMonthName()
                    tvMarketName.text = marketName
                    tvOrderName.text = orderName
                    tvPrice.text = productPrice.withCurrency()
                    tvStatusText.text = productState.type
                    ivStatus.setDrawable(productState.color)
                    tvDetail.text = productDetailRawViewItem.orderDetail
                    tvDetailPrice.text = productDetailRawViewItem.summaryPrice.withCurrency()

                    ivExpandCollapseArrow.setOnClickListener {
                        setIsExpanded(getIsExpanded().not())
                        it.rotate(getIsExpanded(), onAnimationEnd = {
                            layoutDetail.isVisible = getIsExpanded()
                        })
                    }
                    orderLayout.setOnClickListener {
                        setIsExpanded(getIsExpanded().not())
                        ivExpandCollapseArrow.rotate(getIsExpanded(), onAnimationEnd = {
                            layoutDetail.isVisible = getIsExpanded()
                        })
                    }
                }
            }
        }
    }
}
