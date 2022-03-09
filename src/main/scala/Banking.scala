import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Banking {

  def main(args: Array[String]): Unit = {
    println("Welcome back to Trusted Bank, Savannah!")
    println("How can we help you today?")
    println("Type 1 to see your account details")

    var customerName : String = "Savannah Jones"
    var accountNumber : Int = 4567
    var memberSince : Int = 2016

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

    }
    val help = readInt()
    if (help == 1 ){
      accountDetails()
    }
    if (help == 2){
      println("Type 1 for Checking or 2 for Savings")
      val help2 = readInt()
      if (help2 == 1){
        //println("You have ___ in your checking account")
        println("Type 1 to make a deposit or 2 to withdraw")
        val help3 = readInt()
        if (help3 ==1){
          //add to initial amount
        }
        if (help == 2){
          //subtract from initial amount
        }
      }
      if (help ==2){
        //println("You have ___ in your savings account")
        //interest rate
      }
    }
    if (help ==3){
      //println("What kind of account?")
    }
    if (help == 4){
      //println("Thank you for using Trusted Bank!")
      //close application
    }



  }
}
