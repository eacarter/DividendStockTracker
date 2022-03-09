package com.appsolutions.dividendstocktracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appsolutions.dividendstocktracker.data.Ticker
import com.appsolutions.dividendstocktracker.repository.TickerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tickerDBRepo: TickerRepository): ViewModel() {

    fun getTickerList(): LiveData<List<Ticker>> {
        return tickerDBRepo.getTickerList()
    }

}