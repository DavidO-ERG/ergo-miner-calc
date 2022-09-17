package controllers

import models.ErgoPriceDAO
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import javax.inject.Inject
import scala.concurrent.ExecutionContext


class DBConnections @Inject()(ErgoPriceDAO: ErgoPriceDAO, controllerComponents: ControllerComponents)(
  implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  // def list = Action {
  //     Ok(html.stock.list(StockDao.selectAll()))
  // }

  def openConnection(): Action[AnyContent] = Action.async {
    ErgoPriceDAO.all().map { allPrices =>
      Ok(views.html.teste(allPrices))
    }

  }
}
