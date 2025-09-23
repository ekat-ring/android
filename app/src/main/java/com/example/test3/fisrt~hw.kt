#!/usr/bin/env kotlin
package com.example.test3
//LIST

class NumberListProcessor(private val numbers: List<Int>) {
    fun evenNum() {
        numbers
            .filter { it % 2 == 0 }
        println(numbers)
    }
}


//FACTORIAL
class Factorial (private val n: Int) {
    fun factor() {
        var res = 1
        for (x in 1..9) {
            res *= x
        }
        println(res)
    }
}
//RECTANGLE

class Rectangle(val height: Int, val length: Int) {
    fun area(): Int {
        return height * length
    }
}

//REVERSE
fun reverse (){
    val str = "kotlin"
//    var l = str.length
//    for (i in l downto 1){ //    for (i in 1..l){
//        print(str[i])      //       print(str[l-i])
    print(str.reversed())
    //   }

}


//PAYMENT
open class Payment(var amount: Double) {
    open fun process() {
        println("Processing payment of $amount")
    }
}

class CreditCardPayment (amount: Double) : Payment (amount) {
    override fun process (){
        println("Paid $amount with credit card")
    }
}
class PayPalPayment (amount: Double) : Payment (amount) {
    override fun process (){
        println("Paid $amount with PayPal")
    }
}
class BankTransferPayment (amount: Double) : Payment (amount) {
    override fun process (){
        println("Paid $amount with transfer")
    }
}
fun main() {
    val filtered = NumberListProcessor(listOf(1, 3, 7, 15, 67, 102))
    filtered.evenNum()
    val fct = Factorial(5)
    fct.factor()
    val square = Rectangle(5, 5)
    square.area()

    val bank_payment_test = BankTransferPayment(55.5)
    bank_payment_test.process()
}

