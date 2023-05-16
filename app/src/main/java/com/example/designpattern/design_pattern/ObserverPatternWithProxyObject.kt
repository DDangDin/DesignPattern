package com.example.designpattern.design_pattern

// Observers, Professor, ProxyProfessor

interface Professor {
    fun subscribe(observer: Observer)
    fun unSubscribe(observer: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update()
}

class ConcreteProfessor: Professor {

    private val observers = mutableListOf<Observer>()

    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    override fun unSubscribe(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update() }
    }
}

class ConcreteObserver: Observer {
    override fun update() {
        println("do homework!!!")
    }
}

class ProxyProfessor(private val professor: Professor): Professor {
    override fun subscribe(observer: Observer) {
        professor.subscribe(observer)
    }

    override fun unSubscribe(observer: Observer) {
        professor.unSubscribe(observer)
    }

    override fun notifyObservers() {
        println("ProxyProfessor 들림")
        professor.notifyObservers()
    }
}



fun main() {

    val professor = ConcreteProfessor()

    val observer1 = ConcreteObserver()
    val observer2 = ConcreteObserver()

    val proxyProfessor = ProxyProfessor(professor)

    proxyProfessor.subscribe(observer1)
    proxyProfessor.subscribe(observer2)

    proxyProfessor.notifyObservers()

}