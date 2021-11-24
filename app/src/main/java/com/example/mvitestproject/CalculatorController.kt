package com.example.mvitestproject

import com.arkivanov.mvikotlin.core.binder.Binder
import com.arkivanov.mvikotlin.core.binder.BinderLifecycleMode
import com.arkivanov.mvikotlin.core.lifecycle.Lifecycle
import com.arkivanov.mvikotlin.core.lifecycle.doOnDestroy
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.events
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory

class CalculatorController(lifecycle: Lifecycle) {

    private val store = CalculatorStoreFactory(DefaultStoreFactory).create()
    private var binder: Binder? = null

    init {
        lifecycle.doOnDestroy(store::dispose)
    }

    fun onViewCreated(view: CalculatorView, viewLifecycle: Lifecycle) {
        bind(viewLifecycle, BinderLifecycleMode.START_STOP) {
            store.states bindTo view
            // Use store.labels to bind Labels to a consumer
            view.events bindTo store
        }
    }
    // Use store.labels to bind Labels to a consumer

    fun onStart() {
        binder?.start()
    }

    fun onStop() {
        binder?.stop()
    }

    fun onViewDestroyed() {
        binder = null
    }

    fun onDestroy() {
        store.dispose()
    }
}