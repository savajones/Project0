import java.sql.{Connection, DriverManager}
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt



object Banking {

  def main(args: Array[String]): Unit = {

    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/Bankingapp"
    val username = "root"
    val password = "password"
    var connection: Connection = null

    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

    val statement = connection.createStatement()
    val statement2 = connection.createStatement()
    val statement3 = connection.createStatement()
    val statement4 = connection.createStatement()
    val statement5 = connection.createStatement()
    val statement6 = connection.createStatement()
    val statement7 = connection.createStatement()
    val statement8 = connection.createStatement()

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
    }
    def checkingAccount(): Unit={
      println("Please verify your account number")
      val accountNumber = readInt()
      val cb = statement2.executeQuery(s"SELECT checking FROM accounts WHERE account_number=$accountNumber")
      while (cb.next()){
        var cb2 = cb.getInt("checking")
        println(s"You have $$$cb2.00 in your account")
        println("Type 1 to make a deposit or 2 to withdraw")
        val help3 = readInt()
        help3 match {
          case 1 =>
            println("How much would you like to deposit?")
            val deposit = readInt()
            cb2 += deposit
            println(f"Your new balance is $$$cb2.00")
            statement3.executeUpdate(s"UPDATE accounts SET checking=$cb2 WHERE account_number=$accountNumber")
            case 2 =>
              println("How much would you like to withdraw?")
              val withdrawal = readInt()
              if (withdrawal > 500) {
                println("DECLINED: Overdraft limit is $500")
                println("Please enter a different amount to withdraw")
                val withdrawal2 = readInt()
                cb2 -= withdrawal2
                println(f"Your new balance is $$$cb2.00")
              }
              else {
                cb2 -= withdrawal
                println(f"Your new balance is $$$cb2.00")
              }
              statement4.executeUpdate(s"UPDATE accounts SET checking=$cb2 WHERE account_number=$accountNumber")

            //updates with deposit not withdrawal
        }
      }

    }
    def savingsAccount(): Unit={
      println("Please verify your account number")
      val accountNumber = readInt()
      val sb = statement5.executeQuery(s"SELECT savings FROM accounts WHERE account_number=$accountNumber")
      while (sb.next()){
        val sb2 = sb.getInt("savings")
        println(s"You have $$$sb2.00 in your account")
        println("Type 1 to see current interest")
        val help4 = readInt()
        help4 match{
          case 1 =>
            val in = statement6.executeQuery(s"SELECT interest_rate FROM interest WHERE year=2020 AND account_number=$accountNumber")
            while (in.next()){
              val in2 = in.getInt("interest_rate")
              println(s"Your current interest rate is $in2%")
            }
        }
      }
    }
    def newAccount(): Unit={
      val accountName = readLine("What is your name?")
      //val na = statement7.executeQuery(s"SELECT * FROM customer")
      //while (na.next()){
          println("How much are you putting in your checking account?")
          val accountAmount = readInt()
          println(
            f"""
             |Name: $accountName
             |Opening Checking Balance: $$$accountAmount.00
             |Account Number: $accountNumber
             |""".stripMargin)
          statement8.executeUpdate(s"INSERT INTO customer (name,account_number,member_since) VALUES ('$accountName','$accountNumber','2022')")
          println("How much are you putting into your savings account?")
          val accountAmount2 = readInt()
          println(
            f"""
               |Name: $accountName
               |Opening Savings Balance: $$$accountAmount2.00
               |Interest Rate: 3.2%%
               |Account Number: $accountNumber
               |""".stripMargin)
          val in4 = statement.executeQuery(s"SELECT account_id FROM customer WHERE account_number=$accountNumber")
          while(in4.next()) {
            val in5 = in4.getInt("account_id")
            statement7.executeUpdate(s"INSERT INTO accounts (account_number,checking,savings,account_id) VALUES ('$accountNumber','$accountAmount','$accountAmount2','$in5')")
          }
          println("*Please remember your account number*")
          /*println("How much are you putting in your savings account?")
          val accountAmount2 = readInt()
              println(
                f"""
                   |Name: $accountName
                   |Opening Balance: $$$accountAmount2
                   |Account Number: $accountNumber
                   |Interest Rate: 3.8
                   |""".stripMargin)*/


      }
      //update tables


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
            b match {
              case 1 =>
                checkingAccount()
                println("Type 1 to access your savings account or 2 to leave the bank")
                val a2 = readInt()
                a2 match {
                  case 1 =>
                    savingsAccount()
                    println("Thank you for using Trusted Bank!")
                  case 2 =>
                    println("Thank you for using Trusted Bank!")
                }
              case 2 =>
                savingsAccount()
                println("Type 1 to access your checking account or 2 to leave the bank")
                val a3 = readInt()
                a3 match {
                  case 1 =>
                    checkingAccount()
                    println("Thank you for using Trusted Bank!")
                  case 2 =>
                    println("Thank you for using Trusted Bank!")
                }
            }
          case 2 =>
            println("Thank you for using Trusted Bank!")
        }
      case 2 =>
        println("Type 1 for Checking or 2 for Savings")
        val help2 = readInt()
        help2 match {
          case 1 =>
            checkingAccount()
            println("Type 1 to access your savings account or 2 to leave the bank")
            val a4 = readInt()
            a4 match {
              case 1 =>
                savingsAccount()
                println("Thank you for using Trusted Bank!")
              case 2 =>
                println("Thank you for using Trusted Bank!")
            }
          case 2 =>
            savingsAccount()
            println("Type 1 to access your checking account or 2 to leave the bank")
            val a5 = readInt()
            a5 match {
              case 1 =>
                checkingAccount()
                println("Thank you for using Trusted Bank!")
              case 2 =>
                println("Thank you for using Trusted Bank!")
            }
        }
      case 3 =>
        newAccount()
        println("Account created successfully!")
        println("Thank you for using Trusted Bank!")
      case 4 =>
        println("Thank you for using Trusted Bank!")
    }

    //val demo = scala.io.Source.fromFile("read.csv").mkString
    //var inputString = new String
    //inputString = s"INSERT INTO customer VALUES($demo);"
    //statement.executeUpdate(inputString)

    //println("Read from CSV:")
    //val bufferedSource = io.Source.fromFile("read.csv")
    //for (line <- bufferedSource.getLines){
      //val cols = line.split(",").map(_.trim)
      //println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    //}

  }
}


