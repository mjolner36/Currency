package com.learn.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learn.currency.data.ValuteDay
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
   fun getValutes(){
       Repository(RetrofitInstance.retrofit).getValutes().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ValuteDay> {
                override fun onNext(valuteDay: ValuteDay) {
                    valuteDay.valutes.entries.forEach {
                        println(it.value.name + " " + it.value.value)
                    }
                }
                override fun onError(e: Throwable) {

                }
                override fun onComplete() {
                }
                override fun onSubscribe(d: Disposable) {

                }
            })
    }
}