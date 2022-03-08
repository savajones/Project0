import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Banking {

  def main(args: Array[String]): Unit = {
    println("Welcome back to Trusted Bank, Savannah!")
    val accountIntro: String = readLine("What account would you like to access: Checking or Savings?")
    println(s"Let's take a look at your $accountIntro account!")

    val option: String = readLine("Would you like to make a deposit, withdrawal, or transfer funds?")




  }
}
