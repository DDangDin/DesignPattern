package com.example.designpattern.design_pattern

interface PaymentStrategy {
    fun pay(amount: Int)
}

class KAKAOCardStrategy(
    private var name: String,
    private var cardNumber: String,
    private var cvv: String,
    private var dateOfExpiry: String,
): PaymentStrategy {

    override fun pay(amount: Int) {
        println("${amount} paid using KAKAOCard.")
    }
}

 class LUNACardStrategy(
     private var emailId: String,
     private var password: String
 ): PaymentStrategy {

     override fun pay(amount: Int) {
         println("${amount} paid using LUNACard.")
     }
 }

class Item(
    var name: String,
    var price: Int
) { }

class ShoppingCart(
    private var items: ArrayList<Item> = arrayListOf()
) {

    fun addItem(item: Item) {
        items.add(item)
    }

    fun removeItem(item: Item) {
        items.remove(item)
    }

    private fun calculateTotal(): Int {
        var sum = 0
        items.forEach { item ->
            sum += item.price
        }
        return sum
    }

    fun pay(paymentMethod: PaymentStrategy) {
        val amount = calculateTotal()
        paymentMethod.pay(amount)
    }
}


fun main() {

    val cart = ShoppingCart()

    val A = Item(name = "Item_A", price = 100)
    val B = Item(name = "Item_B", price = 300)

    cart.addItem(A)
    cart.addItem(B)

    // pay by LUNACard
    cart.pay(LUNACardStrategy(emailId = "lunacard@gmail.com", password = "12345"))
    // pay by KAKAOCard
    cart.pay(KAKAOCardStrategy("kakaocard@gmail.com", "12345", "12345", "12345"))

}