package models

import controllers.DBConnections
import models.APIs.{callCoinGecko, callWhatToMine}

object DBController {
  // Tables Name
  val priceTable = "ErgoPrice"
  val whatToMineTable = "WhatToMine"
  val minerTable = "Miner"

  // General Columns
  val colId = "id"
  val colTimestamps = "timestamps"

  // ErgoPrice Columns
  val colSymbol = "symbol"
  val colPrice = "price"

  // WhatToMine Columns
  val colNetHash = "networkHashrate"
  val colBlockReward = "blockReward"
  val colBlockTime = "blockTime"

  // Miner Columns
  val colFarmRevenue = "farmRevenue"
  val colFarmCost = "farmCost"
  val colFarmDiff = "farmDiff"

  // Limit Query to last X
  val limit: Int = 6

  // Queries
  val getAllPrices = s"SELECT * FROM $priceTable ORDER BY $colId DESC LIMIT $limit"
  val getAllWhatToMine = s"SELECT * FROM $whatToMineTable ORDER BY $colId DESC LIMIT $limit"
  val getAllMiner = s"SELECT * FROM $minerTable ORDER BY $colId DESC LIMIT $limit"
  val timestamps = s"(SELECT CURRENT_TIMESTAMP)"

  // Get data from API's and store in Database
  def insertPrices(): String = s"INSERT ${priceTable}  (${colTimestamps}, ${colSymbol}, ${colPrice}) VALUES (${timestamps}, 'eur', ${callCoinGecko.head});"

  def insertNetwork(): String = s"INSERT ${whatToMineTable} (${colTimestamps}, ${colNetHash}, ${colBlockReward}, ${colBlockTime}) VALUES (${timestamps}, ${callWhatToMine.head},${callWhatToMine(1)},${callWhatToMine(2)});"

  def insertMiner(revenue: String, cost: String, diff: String): String = {
    s"INSERT ${minerTable}  (${colTimestamps}, ${colFarmRevenue}, ${colFarmCost}, ${colFarmDiff}) VALUES (${timestamps}, ${revenue}, ${cost}, ${diff});"
  }

  //  val deleteAllPrices = "DELETE FROM ErgoPrice WHERE id <> 0;"

  def saveToDB(): Seq[Any] = {
    Seq(
      DBConnections.updateDataDB(insertPrices()),
      DBConnections.updateDataDB(insertNetwork()))
  }

  def getCoinGecko: Seq[String] = {
    val resultsId = DBConnections.getDataDB(getAllPrices, colId)
    val resultsTimestamps = DBConnections.getDataDB(getAllPrices, colTimestamps)
    val resultsSymbol = DBConnections.getDataDB(getAllPrices, colSymbol)
    val resultsPrice = DBConnections.getDataDB(getAllPrices, colPrice)
    Seq(resultsId, resultsTimestamps, resultsSymbol, resultsPrice)
  }

  def getWhatToMine: Seq[String] = {
    val resultsId = DBConnections.getDataDB(getAllWhatToMine, colId)
    val resultsTimestamps = DBConnections.getDataDB(getAllWhatToMine, colTimestamps)
    val resultsNetHash = DBConnections.getDataDB(getAllWhatToMine, colNetHash)
    val resultsBlockReward = DBConnections.getDataDB(getAllWhatToMine, colBlockReward)
    val resultsBlockTime = DBConnections.getDataDB(getAllWhatToMine, colBlockTime)
    Seq(resultsId, resultsTimestamps, resultsNetHash, resultsBlockReward, resultsBlockTime)
  }

  def getMiner: Seq[String] = {
    val resultsId = DBConnections.getDataDB(getAllMiner, colId)
    val resultsTimestamps = DBConnections.getDataDB(getAllMiner, colTimestamps)
    val resultsFarmRevenue = DBConnections.getDataDB(getAllMiner, colFarmRevenue)
    val resultsFarmCost = DBConnections.getDataDB(getAllMiner, colFarmCost)
    val resultsFarmDiff = DBConnections.getDataDB(getAllMiner, colFarmDiff)
    Seq(resultsId, resultsTimestamps, resultsFarmRevenue, resultsFarmCost, resultsFarmDiff)
  }

}
