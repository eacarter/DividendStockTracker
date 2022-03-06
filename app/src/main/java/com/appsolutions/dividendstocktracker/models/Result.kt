package com.appsolutions.dividendstocktracker.models

data class Result(
    val cash_amount: Double,
    val declaration_date: String,
    val dividend_type: String,
    val ex_dividend_date: String,
    val frequency: Int,
    val pay_date: String,
    val record_date: String,
    val ticker: String
)