package com.example.mvitestproject

import com.arkivanov.mvikotlin.core.store.Reducer

class CalculatorReducerImpl : Reducer<CalculatorStore.State, CalculatorStore.Result> {
    override fun CalculatorStore.State.reduce(result: CalculatorStore.Result): CalculatorStore.State {
        return when (result) {
            is CalculatorStore.Result.OnValueChange -> copy(value = result.n)
        }
    }
}