package com.appsolutions.dividendstocktracker.viewmodels

import androidx.lifecycle.ViewModel
import com.appsolutions.dividendstocktracker.repository.MarketRepository
import com.appsolutions.dividendstocktracker.repository.TickerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StockInfoViewModel @Inject constructor(
    private val tickerDBRepo: TickerRepository,
    private val marketRepository: MarketRepository
): ViewModel(){


}