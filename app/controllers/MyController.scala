package controllers

import javax.inject._
import play.api.mvc._
import models.APIs._

@Singleton
class MyController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  // API URL's
  val urlCoinGecko: String = "https://api.coingecko.com/api/v3/simple/price?ids=ergo&vs_currencies=eur"
  val urlWhatToMine: String = "https://whattomine.com/coins/340.json"

  // File Location
  val fileCoinGecko = "./MinerStats/ErgoPrice.json"
  val fileWhatToMine = "./MinerStats/WhatToMine.json"

  // API Call's
  val callCoinGecko: Seq[String] = callApi(urlCoinGecko, fileCoinGecko)
  val callWhatToMine: Seq[String] = callApi(urlWhatToMine, fileWhatToMine)

  // Send to Database


  def index(): Action[AnyContent] = Action {
      Ok(views.html.index(
        callCoinGecko,
        callWhatToMine
      ))
  }

  def openReports(): Action[AnyContent] = Action {
    Ok(views.html.reports())
  }
}
