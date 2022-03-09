package com.appsolutions.dividendstocktracker.repository

import com.appsolutions.dividendstocktracker.models.Dividend
import com.appsolutions.dividendstocktracker.models.Stock
import com.appsolutions.dividendstocktracker.util.Resource

interface MarketRepository {
    suspend fun getSymbol(ticker: String): Resource<Dividend>
    suspend fun getStock(symbol: String): Resource<Stock>
}