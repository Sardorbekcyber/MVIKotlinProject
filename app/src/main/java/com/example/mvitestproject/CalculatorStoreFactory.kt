package com.example.mvitestproject

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

class CalculatorStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): CalculatorStore = object : CalculatorStore, Store<CalculatorStore.Intent,
            CalculatorStore.State, CalculatorStore.Label> by storeFactory.create(
        name = "Calculator Store",
        initialState = CalculatorStore.State(0),
        executorFactory = ::CalculatorExecutorImpl,
        reducer = CalculatorReducerImpl()
    ) {}

}