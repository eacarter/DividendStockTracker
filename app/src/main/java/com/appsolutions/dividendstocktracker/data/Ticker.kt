package com.appsolutions.dividendstocktracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticker_table")
data class Ticker(
    @PrimaryKey @ColumnInfo(name = "symbol") val tickerSymbol: String,
    @ColumnInfo(name = "frequency") val tickerFrequency: String,
    @ColumnInfo(name = "cash_amt") val tickerCashAmt: Double,
    @ColumnInfo(name = "pay_date") val tickerPayDate: String,
)
