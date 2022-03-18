package com.learn.currency.data

import com.google.gson.annotations.SerializedName


data class ValuteDay(
    @SerializedName("Valute")
    val valutes:HashMap<String,Valute>
)

data class Valute(
    @SerializedName("Name")
    val name:String,
    @SerializedName("Value")
    val value:Long
)