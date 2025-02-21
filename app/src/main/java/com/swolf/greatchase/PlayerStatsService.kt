package com.swolf.greatchase

import com.swolf.greatchase.api.StatsApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private val client =
  OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

private val retrofit =
  Retrofit.Builder()
    .baseUrl("https://api-web.nhle.com/vi/")
    .client(client)
    .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
    .build()

val playerStatsApi = retrofit.create(StatsApi::class.java)
