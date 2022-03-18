package com.learn.currency

import androidx.lifecycle.ViewModel
import com.learn.currency.data.ValuteDay
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    init {
        getValutes()
    }
    fun getValutes(){
        repository.getValutes().subscribeOn(Schedulers.io())
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