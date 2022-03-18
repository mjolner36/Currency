package com.learn.currency

import android.database.Observable
import com.learn.currency.data.ValuteDay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET

interface ApiService {

    @GET("daily_json.js")
    fun getDailyValutes(): Observable<ValuteDay>
}


object RetrofitInstance {
     var retrofit = Retrofit.Builder()
        .baseUrl("https://www.cbr-xml-daily.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ValuteDay::class.java)
}