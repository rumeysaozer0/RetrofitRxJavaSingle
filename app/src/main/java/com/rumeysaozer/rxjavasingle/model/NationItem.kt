package com.rumeysaozer.rxjavasingle.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NationItem(
    @SerializedName("capital")
    val capital: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("language")
    val language: String,
    @SerializedName("national_sport")
    val nationalSport: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("uid")
    val uid: String
):Parcelable