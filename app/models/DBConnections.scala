package models

import java.sql.{Connection, DriverManager}

object DBConnections {
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3307/MinerStatus?user=root&password=ergonaut"

  def getDataDB(query: String, colName: String): String = {
    var connection: Connection = null
    var counter: String = ""
    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url)
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery(query)
      while (resultSet.next()) {
        counter += Seq(resultSet.getString(colName)) + ","
      }
    }
    catch {
      case e: Throwable => e.printStackTrace()
    }
    connection.close()
    counter
  }

  def updateDataDB(query: String): Any = {
    var connection: Connection = null
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url)
      val statement = connection.createStatement()
      statement.executeUpdate(query)
    }
    catch {
      case e: Throwable => e.printStackTrace()
    }
    connection.close()
  }

}
