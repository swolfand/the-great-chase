package com.swolf.greatchase.repository

import com.swolf.greatchase.PlayerStatsService
import com.swolf.greatchase.model.Badge
import com.swolf.greatchase.model.PlayerData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface StatsRepository {

  fun getPlayerStats(playerId: Int = 8471214): Flow<PlayerDataResult>
}

class StatsRepositoryImpl() : StatsRepository {
  override fun getPlayerStats(playerId: Int): Flow<PlayerDataResult> = flow {
    emit(PlayerStatsService.statsApi.playerStats(playerId = playerId).toPlayerDataResult())
  }
}

data class PlayerDataResult(
  val playerId: Int,
  val teamLogoUrl: String,
  val teamName: String,
  val badges: List<Badge>,
  val playerName: String,
  val playerNumber: Int,
  val playerPosition: String,
  val heroImageUrl: String,
  val headshotImageUrl: String,
  val careerGoals: Int,
  val seasonGoals: Int,
  val last5GamesGoals: Int,
)

fun PlayerData.toPlayerDataResult(): PlayerDataResult {
  return PlayerDataResult(
    playerId = playerId,
    teamLogoUrl = teamLogo,
    badges = badges,
    playerName = firstName.default + " " + lastName.default,
    playerNumber = sweaterNumber,
    playerPosition = position,
    heroImageUrl = heroImage,
    headshotImageUrl = headshot,
    careerGoals = careerTotals.regularSeason.goals,
    seasonGoals = featuredStats.regularSeason.subSeason.goals,
    last5GamesGoals = last5Games.sumOf { it.goals },
    teamName = fullTeamName.default
  )
}
