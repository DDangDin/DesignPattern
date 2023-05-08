package com.example.designpattern.design_pattern

sealed class StateType {
    data class Success(val data: String): StateType()
    data class Error(val message: String): StateType()
    object Loading: StateType()
}

class State {
    fun makeStateLog(s: String, isLoading: Boolean = false) {
        println("log: $s, loading: $isLoading")
    }
}

interface StateFactory {
    fun createState(stateType: StateType): State
}

class NetworkFactory: StateFactory {
    override fun createState(stateType: StateType): State {
        when (stateType) {
            is StateType.Success -> {
                State()
            }
            is StateType.Error -> { State().makeStateLog(s = "error") }
            is StateType.Loading -> { State().makeStateLog(s = "loading", isLoading = true) }
        }
    }
}




fun main() {

}