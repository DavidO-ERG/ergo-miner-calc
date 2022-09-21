package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import javax.inject.{Inject, Singleton}
import models.DBController
import models.APIs.{callCoinGecko, callWhatToMine}

@Singleton
class MyController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index(): Action[AnyContent] = Action {
    Ok(views.html.index(
      callCoinGecko,
      callWhatToMine
    ))
  }
  def showDB(): Action[AnyContent] = Action {
    val prices = DBController.getCoinGecko
    val network = DBController.getWhatToMine
    val miner = DBController.getMiner
    Ok(views.html.dbview(prices, network, miner))
  }

  def openReports : Action[AnyContent] = Action {
    Ok(views.html.reports())
  }
}