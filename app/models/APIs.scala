package models

import play.api.libs.json.{JsValue, Json}
import scala.io.Source.fromURL

object APIs {

  // API URL's
  val urlCoinGecko: String = "https://api.coingecko.com/api/v3/simple/price?ids=ergo&vs_currencies=eur"
  val urlWhatToMine: String = "https://whattomine.com/coins/340.json"

  // API Call's
  lazy val callCoinGecko: Seq[String] = callApi(urlCoinGecko)
  lazy val callWhatToMine: Seq[String] = callApi(urlWhatToMine)

  def callApi(url: String): Seq[String] = {
    val urlFields: Array[String] = url split (":")
    val minFieldsNeeded: Seq[String] = Seq.fill(urlFields.length + 1)("") // min fields to run the HTML Page Offline

    try {
      val data: scala.io.Source = fromURL(url)
      val json: JsValue = Json.toJson(Json.parse(data.mkString))
      data.close()
      url match {
        case api1 if api1 contains "coingecko" => Seq(json("ergo")("eur").toString())
        case api2 if api2 contains "whattomine" =>
          val getNetHashrate = Json.toJson(json("nethash")).toString()
          val getBlockReward = Json.toJson(json("block_reward")).toString()
          val getBlockTime = Json.toJson(json("block_time")).toString()
          Seq((getNetHashrate.toLong / 1000000000000.0).toString, getBlockReward, getBlockTime.replaceAll(""""""", ""))
        case _ => minFieldsNeeded
      }
    }
    catch {
      case _: java.net.NoRouteToHostException |
           _: java.net.UnknownHostException |
           _: com.fasterxml.jackson.core.JsonParseException => minFieldsNeeded
    }
  }
}
