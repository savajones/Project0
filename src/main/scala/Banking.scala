import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Banking {

  def main(args: Array[String]): Unit = {
    println("Welcome to Trusted Jones Bank!")
    val clientName: String = readLine("What is your name?")
    println(s"Hello $clientName, how can I help you today?")
    val help =
      s"""
         |Type "1" to create a new account
         |Type "2" to access an existing account
         |Type "3" to delete your account
         |""".stripMargin
    println(help)
    var one = readInt()
    var two = readInt()
    var three = readInt()


  }
}
