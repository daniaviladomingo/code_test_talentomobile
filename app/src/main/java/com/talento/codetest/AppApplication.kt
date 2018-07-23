package com.talento.codetest

import android.app.Application
import com.talento.codetest.di.application.ApplicationComponent
import com.talento.codetest.di.createApplicationComponent

class AppApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = createApplicationComponent(this)
    }
}