package com.example.fixturepractice.Api

class FixtureServiceImpl : FixtureService {

    companion object {

        private var INSTANCE: FixtureService? = null
        fun getInstance() = INSTANCE?: FixtureServiceImpl().also { INSTANCE = it }

    }

    override suspend fun getFixtures() = FixRetrofitInstance.fixtureService.getFixtures()




}