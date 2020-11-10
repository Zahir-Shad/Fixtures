package com.example.fixturepractice.Api

class Repo {

    companion object {
        private var INSTANCE: Repo? = null
        fun getInstance() = INSTANCE ?: Repo().also { INSTANCE = it }
    }

    suspend fun getFixtures() = FixtureServiceImpl.getInstance().getFixtures()




}