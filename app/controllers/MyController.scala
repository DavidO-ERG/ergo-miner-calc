package controllers

import javax.inject._
import play.api.mvc._
import models.APIs

@Singleton
class MyController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(APIs.callCoinGecko(), APIs.callWhatToMine()))
  }

  def openReports(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.reports())
  }

}
