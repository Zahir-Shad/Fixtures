package com.example.fixturepractice.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CompetitionStage(
    val competition: Competition
) : Parcelable