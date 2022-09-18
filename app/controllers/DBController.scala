package controllers

import models.DBConnections
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import javax.inject.Inject
import models.APIs.{callCoinGecko, callWhatToMine}


class DBController @Inject()(cc: ControllerComponents) extends AbstractController(cc){

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

  // Queries
  val getAllPrices = s"SELECT * FROM $priceTable"
  val getAllWhatToMine = s"SELECT * FROM $whatToMineTable"
  val getAllMiner = s"SELECT * FROM $minerTable"

  val insertPrices = s"INSERT ${priceTable}  (${colTimestamps}, ${colSymbol}, ${colPrice}) VALUES ((SELECT CURRENT_TIMESTAMP), 'eur', ${callCoinGecko.head});"
  val insertNetwork = s"INSERT ${whatToMineTable} (${colTimestamps}, ${colNetHash}, ${colBlockReward}, ${colBlockTime}) VALUES ((SELECT CURRENT_TIMESTAMP), ${callWhatToMine.head},${callWhatToMine(1)},${callWhatToMine(2)});"
  val deletePrices = "DELETE FROM ErgoPrice WHERE id <> 0;"


  def showPrices(): Action[AnyContent] = Action {
    val prices = getCoinGecko
    val network = getWhatToMine
    Ok(views.html.teste(prices, network))
  }

  def getCoinGecko: Seq[String] = {
    DBConnections.updateDataDB(insertPrices)
    val resultsId = DBConnections.getDataDB(getAllPrices, colId)
    val resultsTimestamps = DBConnections.getDataDB(getAllPrices, colTimestamps)
    val resultsSymbol = DBConnections.getDataDB(getAllPrices, colSymbol)
    val resultsPrice = DBConnections.getDataDB(getAllPrices, colPrice)
    Seq(resultsId,resultsTimestamps,resultsSymbol, resultsPrice)
  }

  def getWhatToMine: Seq[String] = {
    DBConnections.updateDataDB(insertNetwork)
    val resultsId = DBConnections.getDataDB(getAllWhatToMine, colId)
    val resultsTimestamps = DBConnections.getDataDB(getAllWhatToMine, colTimestamps)
    val resultsNetHash = DBConnections.getDataDB(getAllWhatToMine, colNetHash)
    val resultsBlockReward = DBConnections.getDataDB(getAllWhatToMine, colBlockReward)
    val resultsBlockTime = DBConnections.getDataDB(getAllWhatToMine, colBlockTime)

    Seq(resultsId, resultsTimestamps, resultsNetHash, resultsBlockReward, resultsBlockTime)
  }

}
