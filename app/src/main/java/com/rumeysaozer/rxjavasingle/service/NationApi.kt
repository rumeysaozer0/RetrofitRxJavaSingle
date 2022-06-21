package com.rumeysaozer.rxjavasingle.service

import com.rumeysaozer.rxjavasingle.model.Nation
import io.reactivex.Single
import retrofit2.http.GET

interface NationApi {

    @GET("nation/random_nation?size=20")
    fun getNation(): Single<Nation>
}