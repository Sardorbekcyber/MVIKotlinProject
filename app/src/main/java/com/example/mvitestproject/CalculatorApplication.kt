package com.example.mvitestproject

import android.app.Application
import com.arkivanov.mvikotlin.timetravel.server.TimeTravelServer

class CalculatorApplication: Application() {

    private val timeTravelServer = TimeTravelServer()

    override fun onCreate() {
        super.onCreate()
        timeTravelServer.start()
    }
}