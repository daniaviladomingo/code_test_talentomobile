package com.talento.codetest.di.components

import com.talento.codetest.di.modules.ActivityModule
import com.talento.codetest.di.qualifiers.PerActivity
import com.talento.codetest.ui.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}