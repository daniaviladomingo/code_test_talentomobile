package com.talento.codetest.di

import com.talento.codetest.AppApplication
import com.talento.codetest.di.activity.ActivityComponent
import com.talento.codetest.di.application.ApplicationComponent

fun createApplicationComponent(appApplication: AppApplication): ApplicationComponent = ApplicationComponent.init(appApplication)

fun createActivityComponent(appApplication: AppApplication): ActivityComponent = ActivityComponent.init(appApplication.applicationComponent)
