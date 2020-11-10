package com.example.fixturepractice.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HomeTeam(
    val abbr: String,
    val alias: String,
    val id: Int,
    val name: String,
    val shortName: String
) : Parcelable