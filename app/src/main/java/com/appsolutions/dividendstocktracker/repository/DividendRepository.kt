package com.appsolutions.dividendstocktracker.repository

import com.appsolutions.dividendstocktracker.models.Dividend
import com.appsolutions.dividendstocktracker.util.Resource

interface DividendRepository {
    suspend fun getSymbol(ticker: String): Resource<Dividend>
}