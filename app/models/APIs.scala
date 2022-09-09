package models

import play.api.libs.json.Json
import scala.io.Source.fromURL
import java.io._
import java.time.{ZoneId, Instant}
import java.time.format.DateTimeFormatter


object APIs {

  val date: String = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withZone(ZoneId.systemDefault).format(Instant.now)

  def callCoinGecko(): String = {
    val getDataFromUrl = fromURL("https://api.coingecko.com/api/v3/simple/price?ids=ergo&vs_currencies=eur")
    val getDataToString = Json.parse(getDataFromUrl.mkString)
    val getJson = Json.toJson(getDataToString("ergo"))
    val priceData: String = getJson("eur").toString()

    savePrice(priceData)
    priceData
  }

  def callWhatToMine(): List[String] = {
    val getDataFromUrl = fromURL("https://whattomine.com/coins/340.json")
    val getDataToString = Json.parse(getDataFromUrl.mkString)
    val getJsonNetHashrate = Json.toJson(getDataToString("nethash")).toString()
    val getJsonBlockReward = Json.toJson(getDataToString("block_reward")).toString()
    val getJsonBlockTime = Json.toJson(getDataToString("block_time")).toString()
    val dataList: List[String] = List((getJsonNetHashrate.toLong / 1000000000000.0).toString, getJsonBlockReward, getJsonBlockTime)

    saveWhatToMine(dataList)
    dataList
  }

  def savePrice(data: String): Unit = {
    val fileErgoPrice = "./public/MinerStats/ErgoPrice.json"
    val writerErgoPrice = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileErgoPrice, true)))
    writerErgoPrice.write("\"" + date + "\":{\"Ergo Price\":" + data + "},\n")
    writerErgoPrice.close()
  }

  def saveWhatToMine(data: List[String]): Unit = {
    val fileWhatToMine = "./public/MinerStats/WhatToMine.json"
    val writerWhatToMine = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWhatToMine, true)))
    writerWhatToMine.write("\"" + date + "\":{\"Network Hashrate\":" + data.head + ", \"Block Reward\":" + data(1) + ", \"Block Time\":" + data(2) + "},\n")
    writerWhatToMine.close()
  }
}
