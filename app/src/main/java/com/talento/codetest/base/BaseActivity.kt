package com.talento.codetest.base

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.talento.codetest.AppApplication
import com.talento.codetest.base.progress.IShowProgress
import com.talento.codetest.di.activity.DaggerActivity
import com.talento.codetest.di.application.ApplicationComponent

abstract class BaseActivity : DaggerActivity(), BaseView {

    lateinit var showProgress: IShowProgress
    var toolbar: Toolbar? =  null

    protected val applicationComponent: ApplicationComponent
        get() = (application as AppApplication).applicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getLayoutId().run {
            if (this != 0) {
                setContentView(this)
            }
        }

        initializeToolbar()
    }

    private fun initializeToolbar() {}

    override fun onStart() {
        super.onStart()
        getScopePresenter().init()
    }

    override fun onStop() {
        getScopePresenter().onStop()
        super.onStop()
    }

    abstract fun getScopePresenter(): ScopePresenter

    abstract fun getLayoutId(): Int

    override fun showProgress(message: String) {
        showProgress.showProgress(message)
    }

    override fun dismissProgress() {
        showProgress.dismissProgress()
    }
}