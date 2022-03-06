package com.appsolutions.dividendstocktracker.util

sealed class Resource<T>(val data: T?, val message: String?) {
    class success<T>(data: T): Resource<T>(data, null)
    class error<T>(message: String): Resource<T>(null, message)

}