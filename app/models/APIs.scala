package models

import play.api.libs.json.{JsValue, Json}
import scala.io.Source.fromURL
import java.io._
import java.time.{ZoneId, Instant}
import java.time.format.DateTimeFormatter

object APIs {

  def callApi(url: String, filePath: String): Seq[String] = {
    val data = fromURL(url)
    val json = Json.toJson(Json.parse(data.mkString))
    data.close()
    saveToFile(json, filePath)
    if (url contains "coingecko") {
      Seq(json("ergo")("eur").toString())
    } else if (url contains "whattomine") {
      val getNetHashrate = Json.toJson(json("nethash")).toString()
      val getBlockReward = Json.toJson(json("block_reward")).toString()
      val getBlockTime = Json.toJson(json("block_time")).toString()
      Seq((getNetHashrate.toLong / 1000000000000.0).toString, getBlockReward, getBlockTime.replaceAll(""""""",""))
    } else {
      Seq("","","")
    }
  }

  def saveToFile(data: JsValue, filename: String): Unit = {
    val date: String = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withZone(ZoneId.systemDefault).format(Instant.now)
    val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true)))
    writer.write("\"" + date + "\":")
    writer.write(Json.stringify(Json.toJson(data)))
    writer.write(",\n")
    writer.close()
  }
}
