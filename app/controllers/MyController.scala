package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import javax.inject.{Inject, Singleton}
import models.APIs.{callCoinGecko, callWhatToMine}

@Singleton
class MyController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

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