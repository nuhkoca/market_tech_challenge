package com.techchallenge.domain

import com.techchallenge.core.UseCase.ObservableUseCase
import com.techchallenge.core.UseCase.Params
import com.techchallenge.data.MarketimViewItemMapper
import com.techchallenge.data.ResponseViewItem
import io.reactivex.Observable
import javax.inject.Inject

class GetOrdersUseCase @Inject constructor(
    private val repository: MarketimRepository,
    private val viewItemMapper: MarketimViewItemMapper
) : ObservableUseCase<Params, List<ResponseViewItem>> {

    override fun execute(params: Params): Observable<List<ResponseViewItem>> =
        repository.getOrders()
            .map { it.map(viewItemMapper::invoke) }
}
