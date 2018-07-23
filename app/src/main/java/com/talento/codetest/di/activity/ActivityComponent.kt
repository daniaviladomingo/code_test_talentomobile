package com.talento.codetest.di.activity

import com.talento.codetest.di.activity.module.ActivityModule
import com.talento.codetest.di.application.ApplicationComponent
import com.talento.codetest.ui.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    companion object {
        fun init(applicationComponent: ApplicationComponent): ActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule())
                .build()
    }
}