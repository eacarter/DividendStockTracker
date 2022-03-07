package com.appsolutions.dividendstocktracker.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.appsolutions.dividendstocktracker.data.Ticker
import com.appsolutions.dividendstocktracker.data.TickerDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TickerRepository @Inject constructor(private val tickerDao: TickerDao){

    @WorkerThread
    fun insertTicker(ticker: Ticker){
        tickerDao.insertTicker(ticker)
    }

    @WorkerThread
    fun deleteTicker(ticker: Ticker){
        tickerDao.deleteTicker(ticker)
    }

    @WorkerThread
    fun updateTicker(ticker: Ticker){
        tickerDao.updateTicker(ticker)
    }

    @WorkerThread
    fun getTicker(ticker: Ticker){
        tickerDao.getTicker(ticker.tickerSymbol)
    }

    fun getTickerList(): LiveData<List<Ticker>> {
        return tickerDao.getTickerList()
    }

}