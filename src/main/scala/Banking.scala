import java.sql.{Connection, DriverManager}
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Banking {

  def main(args: Array[String]): Unit = {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/Bankingapp"
    val username = "root"
    val password = "password"

    var connection:Connection = null
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()

    println("Welcome to Trusted Bank!")
    println("How can we help you today?")
    println("Type 1 to see your account details")

    val customerName : String = "Savannah Jones"
    var accountNumber: Int = 4567
    val memberSince : Int = 2016

    println("Type 2 to access your accounts")
    println("Type 3 to open a new account")
    println("Type 4 to leave the bank")

    def accountDetails(): Unit={
      println(
        s"""
           |Name: $customerName
           |Account Number: $accountNumber
           |Member Since: $memberSince
           |""".stripMargin)
    }
    def checkingAccount(): Unit={
      var checkingBalance: Int = 3000
      println(f"You have $$$checkingBalance.00 in your account")
      println("Type 1 to make a deposit or 2 to withdraw")
      val help3 = readInt()
      help3 match {
        case 1 =>
          println("How much would you like to deposit?")
          val deposit = readInt()
          checkingBalance += deposit
          println(f"Your new balance is $$$checkingBalance.00")
        case 2 =>
          println("How much would you like to withdraw?")
          val withdrawal = readInt()
          if (withdrawal > 500) {
            println("DECLINED: Overdraft limit is $500")
            println("Please enter a different amount to withdraw")
            val withdrawal2 = readInt()
            checkingBalance -= withdrawal2
            println(f"Your new balance is $$$checkingBalance.00")
          }
          else {
            checkingBalance -= withdrawal
            println(f"Your new balance is $$$checkingBalance.00")
          }
      }
      statement.executeUpdate(s"UPDATE accounts SET checking=$checkingBalance WHERE account_number=4567")
    }

    def savingsAccount(): Unit={
      val savingsBalance : Int = 7600
      println(f"You have $$$savingsBalance.00 in your account")
      println("Type 1 to see interest history")
      val help4 = readInt()
      help4 match{
        case 1 => println("interest history")
        // display interest history
        //statement.executeUpdate(s"SELECT * FROM interest (account number specified)
      }
    }
    def newAccount(): Unit={
      val accountName = readLine("What is your name?")
      println("Type 1 for Checking or 2 for Savings")
      val accountType = readInt()
      accountType match {
        case 1 =>
          println("How much are you putting in this account?")
          val accountAmount = readInt()
          accountNumber += 1042
          println(
            f"""
             |Name: $accountName
             |Opening Balance: $$$accountAmount.00
             |Account Number: $accountNumber
             |""".stripMargin)
          //statement.executeUpdate("INSERT INTO customer (account_id) VALUES (2)")
          //statement.executeUpdate(s"INSERT INTO customer (name,account_number,member_since) VALUES ($accountName,$accountNumber,2022")

        case 2 =>
          println("How much are you putting in this account?")
          val accountAmount2 = readInt()
          println(
            f"""
             |Name: $accountName
             |Opening Balance: $$$accountAmount2
             |Account Number: $accountNumber
             |Interest Rate:
             |""".stripMargin)
        //statement.executeUpdate(s"INSERT INTO accounts () VALUES (${},..)
        //statement.executeUpdate(s"INSERT INTO interest () VALUES (${},..)
      }
      //add to customer table
    }

    val help = readInt()
    help match{
      case 1 =>
        accountDetails()
        println("What would you like to do next?")
        println("Type 1 to manage your accounts")
        println("Type 2 to leave the bank")
        val a = readInt()
        a match{
          case 1 =>
            println("Type 1 for checking or 2 for savings")
            val b = readInt()
            b match{
              case 1 =>
                checkingAccount()
              case 2 =>
                savingsAccount()
            }
          case 2 =>
            println("Thank you for using Trusted Bank!")
        }
      case 2 =>
        println("Type 1 for Checking or 2 for Savings")
        val help2 = readInt()
      help2 match{
        case 1 =>
          checkingAccount()
        case 2 =>
          savingsAccount()
      }
      case 3 =>
        newAccount()
      case 4 =>
        println("Thank you for using Trusted Bank!")
    }
  }
}
