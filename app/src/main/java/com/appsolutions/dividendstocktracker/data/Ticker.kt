package com.appsolutions.dividendstocktracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticker_table")
data class Ticker(
    @PrimaryKey @ColumnInfo(name = "symbol") val tickerSymbol: String,
    @ColumnInfo(name = "frequency") val tickerFrequency: Int,
    @ColumnInfo(name = "cash_amt") val tickerCashAmt: Double,
    @ColumnInfo(name = "pay_date") val tickerPayDate: String,
    @ColumnInfo(name = "num_shares") val tickerNumShares: Double,
    @ColumnInfo(name = "avg_cost") val tickerAvgCost: Double
)
