package com.example.designpattern.design_pattern

class SingletonPattern private constructor() {
    companion object {

        private var instance: SingletonPattern? = null

        fun getInstance(): SingletonPattern {
            return instance ?: synchronized(this) {
                instance ?: SingletonPattern().also { instance = it }
            }
        }
    }
}




fun main() {

}