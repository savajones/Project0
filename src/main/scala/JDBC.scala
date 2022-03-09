import java.sql.{Connection, DriverManager}
import java.sql.PreparedStatement
import java.sql.SQLException

object JDBC {
  def main(args: Array[String]) {

    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/Bankingapp"
    val username = "root"
    val password = "password"

    var connection:Connection = null

    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM accounts;")
      while ( resultSet.next() ) {
        println(resultSet.getString(1)+", " +resultSet.getString(2) +", " +resultSet.getString(3))
      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    connection.close()
  }
}
