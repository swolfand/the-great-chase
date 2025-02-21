package com.swolf.greatchase.api

import retrofit2.http.GET
import retrofit2.http.Path

interface StatsApi {

  @GET("/player/{playerId}/landing") fun playerStats(@Path("playerId") playerId: Int): PlayerData
}
