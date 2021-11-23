package com.example.mvitestproject

import com.arkivanov.mvikotlin.core.store.Store

internal interface CalculatorStore : Store<CalculatorStore.Intent, CalculatorStore.State, CalculatorStore.Label> {

    sealed class Action {
        object Initialize : Action()
    }

    sealed class Intent {
        object Increment : Intent()
        object Decrement : Intent()
        data class Sum(val n: Int) : Intent() // <-- Add this line
    }

    sealed class Result {
        data class OnValueChange(val n: Int) : Result()
    }

    data class State(
        val value: Int = 0
    )

    sealed class Label {
        object Close: Label()
    }
}