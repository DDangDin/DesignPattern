package com.example.designpattern.design_pattern

interface EventListener {
    fun onEvent(count: Int)
}

class Counter(var listener: EventListener) {
    fun count() {
        for (i in 1..100) {
            if (i % 5 == 0) {
                listener.onEvent(i)
            }
        }
    }
}

//class EventPrinter: EventListener {
//    override fun onEvent(count: Int) {
//        print("($count) ")
//    }
//
//    fun start() {
//        // 여기서 this는 EventPrinter 객체 자신을 나타내지만 받는 쪽(Counter)에서
//        // EventListener만 요구했기 때문에 EventListener 구현부만 넘겨주게됨
//        // -> 이를 객체지향의 다형성
//        Counter(this).count()
//    }
//}

// 다른 방법
class EventPrinter {
    fun start() {
        Counter(object: EventListener {
            override fun onEvent(count: Int) {
                print("(${count}) ")
            }
        }).count()
    }
}

fun main() {
    EventPrinter().start()
}