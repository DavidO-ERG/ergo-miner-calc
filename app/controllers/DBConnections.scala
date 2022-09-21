package controllers

import java.sql.{Connection, DriverManager}

object DBConnections {
  val url = "jdbc:mysql://localhost:3307/MinerStatus?user=root&password=ergonaut"

  def getDataDB(query: String, colName: String): String = {
    var connection: Connection = null
    var counter: String = ""
    try {
      connection = DriverManager.getConnection(url)
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery(query)
      while (resultSet.next()) {
        counter += resultSet.getString(colName) + ","
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
