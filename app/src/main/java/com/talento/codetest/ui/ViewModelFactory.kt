package com.talento.codetest.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase

class ViewModelFactory(private val getAccountSingleUseCase: GetAccountSingleUseCase,
                       private val scheduleProvider: IScheduleProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(MainViewModule::class.java) -> MainViewModule(getAccountSingleUseCase, scheduleProvider)
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")

                }
            } as T
}