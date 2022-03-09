package com.appsolutions.dividendstocktracker.repository

import com.appsolutions.dividendstocktracker.data.DividendApi
import com.appsolutions.dividendstocktracker.models.Dividend
import com.appsolutions.dividendstocktracker.models.Stock
import com.appsolutions.dividendstocktracker.util.Resource
import javax.inject.Inject

class DefaultRepository @Inject constructor (
    private val api: DividendApi
        ): MarketRepository {

    override suspend fun getSymbol(ticker: String): Resource<Dividend> {
        return try{
            val response = api.getDividend(ticker)
            val result = response.body()
            if(response.isSuccessful && result != null){
                Resource.success(result)
            }
            else{
                Resource.error(response.message())
            }
        }
        catch(e: Exception){
            Resource.error(e.message ?: "An error has occured")
        }
    }

    override suspend fun getStock(symbol: String): Resource<Stock> {
        return try{
            val response = api.getStock(symbol)
            val result = response.body()
            if(response.isSuccessful && result != null){
                Resource.success(result)
            }
            else{
                Resource.error(response.message())
            }
        }
        catch(e: Exception){
            Resource.error(e.message ?: "An error has occured")
        }
    }
}