package com.appsolutions.dividendstocktracker.data

import com.appsolutions.dividendstocktracker.models.Dividend
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DividendApi {

    @GET("dividends")
    suspend fun getDividend(@Query("ticker") symbol : String,
                            @Query("apiKey") key: String = "jgzAUZIpoGlhahwZRhHGhoGT0RalYfKe")
    : Response<Dividend>

}