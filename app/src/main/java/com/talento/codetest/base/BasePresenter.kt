package com.talento.codetest.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<View: BaseView>: ScopePresenter<View> {

    protected lateinit var view: View
    private val compositeDisposable = CompositeDisposable()

    override fun onAttachView(view: View) {
        this.view = view
    }

    protected fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    override fun onStop() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
