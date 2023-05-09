package com.example.designpattern.design_pattern

// 휴대폰을 만드는 공장
interface PhoneFactory {
    fun orderPhone(): Phone {
        val phone = createPhone()
        phone.complete()
        return phone
    }

    fun createPhone(): Phone
}

interface Phone {
    fun complete()
    fun call()
}

class IPhoneFactory: PhoneFactory {
    override fun createPhone(): Phone {
        return IPhone()
    }
}

class AndroidPhoneFactory: PhoneFactory {
    override fun createPhone(): Phone {
        return AndroidPhone()
    }
}

// 아이폰
class IPhone: Phone {
    override fun complete() = println("아이폰 complete")
    override fun call() = println("아이폰 call")
}

// 안드로이드폰
class AndroidPhone: Phone {
    override fun complete() = println("안드로이드폰 complete")
    override fun call() = println("안드로이드폰 call")
}



fun main() {

    val iphoneFactory = IPhoneFactory()
    val iphone14 = iphoneFactory.orderPhone()
    iphone14.call()

    val androidPhoneFactory = AndroidPhoneFactory()
    val pixel6 = androidPhoneFactory.orderPhone()
    pixel6.call()
}