package com.appsolutions.dividendstocktracker.models

data class Stock(
    val request_id: String,
    val results: Results,
    val status: String
)