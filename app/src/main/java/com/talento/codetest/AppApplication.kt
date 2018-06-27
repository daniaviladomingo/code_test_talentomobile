package com.talento.codetest

import android.app.Application
import com.talento.codetest.di.components.ApplicationComponent
import com.talento.codetest.di.components.DaggerApplicationComponent
import com.talento.codetest.di.modules.ApplicationModule

class AppApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}