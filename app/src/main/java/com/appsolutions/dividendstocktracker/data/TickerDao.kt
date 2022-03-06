package com.appsolutions.dividendstocktracker.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE

@Dao
interface TickerDao {

    @Insert(onConflict = IGNORE)
    fun insertTicker(ticker: Ticker)

    @Delete()
    fun deleteTicker(ticker: Ticker)

    @Update()
    fun updateTicker(ticker: Ticker)

    @Query("Select * From ticker_table Where symbol =:symbol")
    fun getTicker(symbol: String): Ticker

    @Query("Select * From ticker_table")
    fun getTickerList() : LiveData<List<Ticker>>
}