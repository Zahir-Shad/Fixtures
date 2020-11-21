package com.example.fixturepractice.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

class MyFixtures : ArrayList<MyFixturesItem>()

@Parcelize
@JsonClass(generateAdapter = true)
data class MyFixturesItem(
    val awayTeam: AwayTeam,
    val competitionStage: CompetitionStage,
    val date: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val state: String,
    val type: String,
    val venue: Venue
) : Parcelable

