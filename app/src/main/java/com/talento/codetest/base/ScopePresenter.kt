package com.talento.codetest.base

interface ScopePresenter<View: BaseView> {
    fun onAttachView(view: View)
    fun onStop()
    fun init()
}