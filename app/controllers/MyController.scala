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

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    try {
      Ok(views.html.index(
        callApi(urlCoinGecko, fileCoinGecko),
        callApi(urlWhatToMine, fileWhatToMine)
      ))
    }
    catch {
      case _ : java.net.NoRouteToHostException |
           _ : java.net.UnknownHostException |
           _ : com.fasterxml.jackson.core.JsonParseException => {
        Ok(views.html.index(
          Seq(""),
          Seq("", "", "")
        ))
      }
    }
  }

  def openReports(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.reports())
  }

}
