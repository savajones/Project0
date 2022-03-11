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

    val accountNumber2 = new scala.util.Random
    val accountNumber = 1000 + accountNumber2.nextInt((9999-1000)+50)

    println("Type 2 to access your accounts")
    println("Type 3 to open a new account")
    println("Type 4 to leave the bank")

    def accountDetails(): Unit={
      println("What is your account number?")
      val accountNumber = readInt()
      val r = statement.executeQuery(s"SELECT * FROM customer WHERE account_number=$accountNumber")
      while (r.next()){
        val s = r.getString("name")
        val t = r.getInt("account_number")
        val u = r.getInt("member_since")
        println(
          s"""
             |Name: $s
             |Account Number: $t
             |Member Since: $u
             |""".stripMargin)
      }
      //if no account println("We could not find a record of that account")
      //println("Please try again or type 1 to create a new account")
    }
    def checkingAccount(): Unit={
      var checkingBalance:Int = 3000
      //println("Please verify your account number")
      //val accountNumber = readInt()
      //val cb = statement.executeQuery(s"SELECT checking FROM accounts WHERE account_number=$accountNumber")
      /*
      while (cb.next()){
        val cb2 = cb.getInt("checking")
        println("You have ___ in your account")
        *insert code below*
      }
       */
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
      statement.executeUpdate(s"UPDATE accounts SET checking=$checkingBalance WHERE account_number=$accountNumber")
    }

    def savingsAccount(): Unit={
      val savingsBalance : Int = 7600
      //println("Please verify your account number")
      //val accountNumber = readInt()
      //val sb = statement.executeQuery(s"SELECT savings FROM accounts WHERE account_number=$accountNumber")
      /*
      while (sb.next()){
        val sb2 = sb.getInt("savings")
        println("You have ___ in your account")
        *insert code below*
      }
       */
      println(f"You have $$$savingsBalance.00 in your account")
      println("Type 1 to see current interest")
      val help4 = readInt()
      help4 match{
        case 1 =>
        // display interest
        //println(statement.executeQuery(s"SELECT interest_rate FROM interest WHERE account_number=$accountNumber AND member_since=2022"))
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
          println(
            f"""
             |Name: $accountName
             |Opening Balance: $$$accountAmount.00
             |Account Number: $accountNumber
             |""".stripMargin)
          //statement.executeLargeUpdate(s"INSERT INTO customer (name,account_number,member_since) VALUES ($accountName,$accountNumber,2022)")
          //statement.executeUpdate(s"INSERT INTO customer (name,account_number,member_since) VALUES ($accountName,$accountNumber,2022")

        case 2 =>
          println("How much are you putting in this account?")
          val accountAmount2 = readInt()
          println(
            f"""
             |Name: $accountName
             |Opening Balance: $$$accountAmount2
             |Account Number: $accountNumber
             |Interest Rate: ___
             |""".stripMargin)
        //statement.executeUpdate(s"INSERT INTO accounts (savings) VALUES ($accountAmount2)")
        //statement.executeUpdate(s"INSERT INTO interest (account_number) VALUES ($accountNumber)")
      }
      //update tables
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
