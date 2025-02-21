package com.swolf.greatchase.api

import com.swolf.greatchase.model.PlayerData
import retrofit2.http.GET
import retrofit2.http.Path

interface StatsApi {

  @GET("/player/{playerId}/landing")
  suspend fun playerStats(@Path("playerId") playerId: Int): PlayerData
}
