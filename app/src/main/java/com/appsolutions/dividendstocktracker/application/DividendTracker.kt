package com.appsolutions.dividendstocktracker.application

import android.app.Application
import com.appsolutions.dividendstocktracker.data.TickerDatabase
import com.appsolutions.dividendstocktracker.repository.TickerRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DividendTracker : Application() {

}