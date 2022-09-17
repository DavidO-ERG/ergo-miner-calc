package models

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile

case class ErgoPrice(
                      val id: Long,
                      val timestamps: String,
                      val symbol: String,
                      val price: Double
                    )


class ErgoPriceDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val ErgoPrices = TableQuery[ErgoPriceTable]

  // SLICK database stuff
  // this first "stocks" string refers to my database table name
  private class ErgoPriceTable(tag1: Tag) extends Table[ErgoPrice](tag1, "ErgoPrice") {
    def id = column[Long]("id", O.PrimaryKey)
    def timestamps = column[String]("timestamps")
    def symbol = column[String]("symbol")
    def price = column[Double]("price")

    def * = (id, timestamps, symbol, price) <> (ErgoPrice.tupled, ErgoPrice.unapply)
  }

  def all(): Future[Seq[ErgoPrice]] = db.run(ErgoPrices.result)
}

