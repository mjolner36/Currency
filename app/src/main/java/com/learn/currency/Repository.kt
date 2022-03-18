package com.learn.currency

import com.learn.currency.data.ValuteDay

class Repository(private val apiService: ValuteDay) {
    fun getValutes() = apiService
}