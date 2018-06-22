package com.talento.codetest.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.talento.codetest.AppApplication
import com.talento.codetest.base.progress.IShowProgress
import com.talento.codetest.di.components.ApplicationComponent
import com.talento.codetest.di.modules.ActivityModule

abstract class BaseActivity : AppCompatActivity(), BaseView {

    lateinit var showProgress: IShowProgress
    var toolbar: Toolbar? =  null

    protected val activityModule: ActivityModule
        get() = ActivityModule(this)

    protected val applicationComponent: ApplicationComponent
        get() = (application as AppApplication).appComponent

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