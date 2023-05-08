package com.example.designpattern.design_pattern

class SingletonPattern private constructor() {
    companion object {

        private var instance: SingletonPattern? = null

        fun getInstance(): SingletonPattern {
            return instance ?: synchronized(this) {
                instance ?: SingletonPattern().also { instance = it }
            }
        }

        fun getInstanceInfo() = instance?.let {
            it.hashCode()
        }
    }
}

class NotSingletonPattern {

    private var instance: NotSingletonPattern? = null
    fun getInstance(): NotSingletonPattern {
        return instance ?: NotSingletonPattern().also { instance = it }
    }

    fun getInstanceInfo() = NotSingletonPattern().instance?.let {
        it.hashCode()
    }
}

fun main() {
    val mySingleton = SingletonPattern.getInstance()
    println(mySingleton.hashCode())
    println(SingletonPattern.getInstanceInfo())
}