package com.appsolutions.dividendstocktracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolutions.dividendstocktracker.models.Dividend
import com.appsolutions.dividendstocktracker.repository.DividendRepository
import com.appsolutions.dividendstocktracker.repository.TickerRepository
import com.appsolutions.dividendstocktracker.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTickerViewModel @Inject constructor(
    private val tickerDBRepo: TickerRepository,
    private val diviRepo: DividendRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    fun getDividend(ticker: String) : LiveData<Dividend> {
        var result = MutableLiveData<Dividend>()

        viewModelScope.launch(dispatchers.io) {
            result.postValue(diviRepo.getSymbol(ticker).data)
        }

        return result
    }

}