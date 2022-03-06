package com.appsolutions.dividendstocktracker.models

data class Dividend(
    val next_url: String,
    val request_id: String,
    val results: List<Result>,
    val status: String
)