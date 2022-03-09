package com.appsolutions.dividendstocktracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolutions.dividendstocktracker.data.Ticker
import com.appsolutions.dividendstocktracker.models.Dividend
import com.appsolutions.dividendstocktracker.repository.MarketRepository
import com.appsolutions.dividendstocktracker.repository.TickerRepository
import com.appsolutions.dividendstocktracker.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTickerViewModel @Inject constructor(
    private val tickerDBRepo: TickerRepository,
    private val diviRepo: MarketRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    fun getDividend(ticker: String, num: Double, avg: Double) : LiveData<Dividend> {
        var result = MutableLiveData<Dividend>()

        viewModelScope.launch(dispatchers.io) {
            result.postValue(diviRepo.getSymbol(ticker).data)

            println(diviRepo.getSymbol(ticker).data!!.results[0])


            //TODO: fix null pointer exception here
            var ticker = Ticker(
                result.value!!.results[0].ticker,
                result.value!!.results[0].frequency,
                result.value!!.results[0].cash_amount,
                result.value!!.results[0].pay_date,
                num,
                avg
            )

            tickerDBRepo.insertTicker(ticker)
        }

        return result
    }

}