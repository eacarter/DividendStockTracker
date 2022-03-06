package com.appsolutions.dividendstocktracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Ticker::class), version = 1, exportSchema = false)
abstract class TickerDatabase : RoomDatabase() {

    abstract fun getTickerDao(): TickerDao

}