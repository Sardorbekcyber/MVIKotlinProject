package com.example.mvitestproject

import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import kotlinx.coroutines.delay

class CalculatorExecutorImpl :
    SuspendExecutor<CalculatorStore.Intent,
            CalculatorStore.Action,
            CalculatorStore.State,
            CalculatorStore.Result,
            CalculatorStore.Label>() {

    override suspend fun executeAction(
        action: CalculatorStore.Action,
        getState: () -> CalculatorStore.State
    ) {
        when (action) {
            CalculatorStore.Action.Initialize -> {
                initialization()
            }
        }
    }

    private suspend fun initialization() {
        delay(1000)
    }

    override suspend fun executeIntent(
        intent: CalculatorStore.Intent,
        getState: () -> CalculatorStore.State
    ) {
        when (intent) {
            CalculatorStore.Intent.Decrement -> {

            }
            CalculatorStore.Intent.Increment -> {

            }
            is CalculatorStore.Intent.Sum -> {

            }
        }
    }
}