package com.rumeysaozer.rxjavasingle.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rumeysaozer.rxjavasingle.model.Nation
import com.rumeysaozer.rxjavasingle.service.NationApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class NationViewModel: ViewModel() {
    private val nationApiService = NationApiService()
    private val disposable = CompositeDisposable()
    val nation = MutableLiveData<Nation>()
    fun getData(){
        disposable.add(
            nationApiService.getNations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<Nation>(){
                    override fun onSuccess(t: Nation) {
                        nation.value= t
                    }

                    override fun onError(e: Throwable) {
                       e.printStackTrace()
                    }

                })
        )
    }
}