package com.talento.codetest.di

import com.talento.codetest.AppApplication
import com.talento.codetest.di.activity.ActivityComponent
import com.talento.codetest.di.activity.DaggerActivity
import com.talento.codetest.di.application.ApplicationComponent

fun createApplicationComponent(appApplication: AppApplication): ApplicationComponent = ApplicationComponent.init(appApplication)

fun createActivityComponent(daggerActivity: DaggerActivity, appApplication: AppApplication): ActivityComponent = ActivityComponent.init(daggerActivity, appApplication.applicationComponent)
