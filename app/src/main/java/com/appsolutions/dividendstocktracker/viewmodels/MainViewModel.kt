package com.appsolutions.dividendstocktracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolutions.dividendstocktracker.data.Ticker
import com.appsolutions.dividendstocktracker.models.Dividend
import com.appsolutions.dividendstocktracker.repository.DividendRepository
import com.appsolutions.dividendstocktracker.repository.TickerRepository
import com.appsolutions.dividendstocktracker.util.DispatcherProvider
import com.appsolutions.dividendstocktracker.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tickerDBRepo: TickerRepository): ViewModel() {

    fun getTickerList(): LiveData<List<Ticker>> {
        return tickerDBRepo.getTickerList()
    }

    fun getAnnualTotal(): Double?{
        //TODO
        return null
    }

    fun getTotalYield(): Double?{
        //TODO
        return null
    }
}