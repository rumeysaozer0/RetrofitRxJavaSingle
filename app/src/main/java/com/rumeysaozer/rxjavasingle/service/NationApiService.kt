package com.rumeysaozer.rxjavasingle.service

import com.rumeysaozer.rxjavasingle.model.Nation
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NationApiService {
    private val BASE_URL = "https://random-data-api.com/api/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NationApi::class.java)
    fun getNations(): Single<Nation>{
        return api.getNation()
    }
}