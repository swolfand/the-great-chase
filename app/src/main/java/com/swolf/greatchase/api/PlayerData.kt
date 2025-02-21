package com.swolf.greatchase.api

import kotlinx.serialization.Serializable

@Serializable
data class PlayerData(
  val playerId: Int,
  val isActive: Boolean,
  val currentTeamId: Int,
  val currentTeamAbbrev: String,
  val fullTeamName: LocalizedString,
  val teamCommonName: LocalizedString,
  val teamPlaceNameWithPreposition: LocalizedString,
  val firstName: LocalizedString,
  val lastName: LocalizedString,
  val badges: List<Badge>,
  val teamLogo: String,
  val sweaterNumber: Int,
  val position: String,
  val headshot: String,
  val heroImage: String,
  val heightInInches: Int,
  val heightInCentimeters: Int,
  val weightInPounds: Int,
  val weightInKilograms: Int,
  val birthDate: String,
  val birthCity: LocalizedString,
  val birthCountry: String,
  val shootsCatches: String,
  val draftDetails: DraftDetails,
  val playerSlug: String,
  val inTop100AllTime: Int,
  val inHHOF: Int,
  val featuredStats: FeaturedStats,
  val careerTotals: CareerTotals,
  val shopLink: String,
  val twitterLink: String,
  val watchLink: String,
  val last5Games: List<GameStats>,
  val seasonTotals: List<SeasonTotal>,
  val awards: List<Award>,
  val currentTeamRoster: List<RosterPlayer>,
)

@Serializable
data class LocalizedString(
  val default: String,
  val cs: String? = null,
  val de: String? = null,
  val es: String? = null,
  val fi: String? = null,
  val fr: String? = null,
  val sk: String? = null,
  val sv: String? = null,
)

@Serializable data class Badge(val logoUrl: LocalizedString, val title: LocalizedString)

@Serializable
data class DraftDetails(
  val year: Int,
  val teamAbbrev: String,
  val round: Int,
  val pickInRound: Int,
  val overallPick: Int,
)

@Serializable data class FeaturedStats(val season: Int, val regularSeason: RegularSeasonStats)

@Serializable data class RegularSeasonStats(val subSeason: StatsDetail, val career: StatsDetail)

@Serializable
data class StatsDetail(
  val assists: Int,
  val gameWinningGoals: Int,
  val gamesPlayed: Int,
  val goals: Int,
  val otGoals: Int,
  val pim: Int,
  val plusMinus: Int,
  val points: Int,
  val powerPlayGoals: Int,
  val powerPlayPoints: Int,
  val shootingPctg: Double,
  val shorthandedGoals: Int,
  val shorthandedPoints: Int,
  val shots: Int,
)

@Serializable
data class CareerTotals(val regularSeason: DetailedStats, val playoffs: DetailedStats)

@Serializable
data class DetailedStats(
  val assists: Int,
  val avgToi: String,
  val faceoffWinningPctg: Double,
  val gameWinningGoals: Int,
  val gamesPlayed: Int,
  val goals: Int,
  val otGoals: Int,
  val pim: Int,
  val plusMinus: Int,
  val points: Int,
  val powerPlayGoals: Int,
  val powerPlayPoints: Int,
  val shootingPctg: Double,
  val shorthandedGoals: Int,
  val shorthandedPoints: Int,
  val shots: Int,
)

@Serializable
data class GameStats(
  val assists: Int,
  val gameDate: String,
  val gameId: Int,
  val gameTypeId: Int,
  val goals: Int,
  val homeRoadFlag: String,
  val opponentAbbrev: String,
  val pim: Int,
  val plusMinus: Int,
  val points: Int,
  val powerPlayGoals: Int,
  val shifts: Int,
  val shorthandedGoals: Int,
  val shots: Int,
  val teamAbbrev: String,
  val toi: String,
)

@Serializable
data class SeasonTotal(
  val assists: Int,
  val gameTypeId: Int,
  val gamesPlayed: Int,
  val goals: Int,
  val leagueAbbrev: String,
  val pim: Int,
  val points: Int,
  val season: Int,
  val sequence: Int,
  val teamName: LocalizedString,
  val teamCommonName: LocalizedString? = null,
  val teamPlaceNameWithPreposition: LocalizedString? = null,
  val faceoffWinningPctg: Double? = null,
  val plusMinus: Int? = null,
  val powerPlayGoals: Int? = null,
  val shootingPctg: Double? = null,
  val shorthandedGoals: Int? = null,
  val shots: Int? = null,
)

@Serializable data class Award(val trophy: LocalizedString, val seasons: List<AwardSeason>)

@Serializable
data class AwardSeason(
  val assists: Int,
  val blockedShots: Int,
  val gameTypeId: Int,
  val gamesPlayed: Int,
  val goals: Int,
  val hits: Int,
  val pim: Int,
  val plusMinus: Int,
  val points: Int,
  val seasonId: Int,
)

@Serializable
data class RosterPlayer(
  val playerId: Int,
  val lastName: LocalizedString,
  val firstName: LocalizedString,
  val playerSlug: String,
)
