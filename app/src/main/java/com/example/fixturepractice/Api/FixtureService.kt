package com.example.fixturepractice.Api

import com.example.fixturepractice.model.MyFixtures
import retrofit2.Response
import retrofit2.http.GET

interface FixtureService {


    @GET("cdn-og-test-api/test-task/fixtures.json")
    suspend fun getFixtures() : Response<List<MyFixtures>>



}