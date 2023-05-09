package com.example.designpattern.design_pattern

interface Payment {
    fun pay(amount: Int)
}

data class CartItem(val name: String, val price: Int)

class KAKAOCard(
    val cardNumber: String,
    val password: String
): Payment {
    override fun pay(amount: Int) {
        println("카카오 카드로 ${amount}원 결제 완료!")
    }
}

class IBKCard(
    val cardNumber: String,
    val password: String,
    val name: String
): Payment {
    override fun pay(amount: Int) {
        println("IBK 카드로 ${amount}원 결제 완료!")
    }
}

class ShoppingMallCart(
    private val items: ArrayList<CartItem> = arrayListOf()
) {

    fun addItem(item: CartItem) {
        items.add(item)
    }

    fun removeItem(item: CartItem) {
        items.remove(item)
    }

    fun priceTotal(): Int {
        var total = 0
        items.forEach { item ->
            total += item.price
        }

        return total
    }

    fun pay(payMethod: Payment) {
        val total = priceTotal()
        payMethod.pay(total)
    }

}


fun main() {

    val cart = ShoppingMallCart()

    val item1 = CartItem("A", 100)
    val item2 = CartItem("B", 200)

    cart.addItem(item1)
    cart.addItem(item2)

    val kakaoPay = KAKAOCard("123", "123")
    val ibkPay = IBKCard("123", "123", "kim")

    cart.pay(kakaoPay)
    cart.pay(ibkPay)

}