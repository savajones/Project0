import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Banking {

  def main(args: Array[String]): Unit = {
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
      println(f"You have $$$checkingBalance%1.2f in your account")
      println("Type 1 to make a deposit or 2 to withdraw")
      val help3 = readInt()
      if (help3 ==1){
        println("How much would you like to deposit?")
        val deposit = readInt()
        checkingBalance += deposit
        println(f"Your new balance is $$$checkingBalance%1.2f")
      }
      if (help3 == 2){
        println("How much would you like to withdraw?")
        val withdrawal = readInt()
        if(withdrawal > 500){
          println("DECLINED: Overdraft limit is $500")
        }
        else{
          checkingBalance -= withdrawal
          println(f"Your new balance is $$$checkingBalance%1.2f")
        }
      }
      //update accounts table
    }
    def savingsAccount(): Unit={
      val savingsBalance : Int = 7600
      println(f"You have $$$savingsBalance%1.2f in your account")
      println("Type 1 to see interest history")
      val help4 = readInt()
      if (help4 == 1){
        // display interest history
      }
    }
    def newAccount(): Unit={
      val accountName = readLine("What is your name?")
      println("How much are you putting in this account?")
      val accountAmount = readInt()
      accountNumber += 1042
      println(
        f"""
           |Name: $accountName
           |Opening Balance: $$$accountAmount%1.2f
           |Account Number: $accountNumber
           |""".stripMargin)
      //add to customer table
    }

    val help = readInt()
    if (help == 1 ){
      accountDetails()
    }
    if (help == 2){
      println("Type 1 for Checking or 2 for Savings")
      val help2 = readInt()
      if (help2 == 1){
        checkingAccount()
      }
      if (help ==2){
        savingsAccount()
      }
    }
    if (help ==3){
      newAccount()
    }
    if (help == 4){
      println("Thank you for using Trusted Bank!")
    }
  }
}
