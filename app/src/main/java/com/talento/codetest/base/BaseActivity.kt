package com.talento.codetest.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.talento.codetest.base.progress.IShowProgress
import com.talento.codetest.utils.Utils

abstract class BaseActivity : AppCompatActivity(), BaseView {

    lateinit var showProgress: IShowProgress
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getLayoutId().run {
            if (this != 0) {
                setContentView(this)
            }
        }

        initializeToolbar()

        requestedOrientation = if (Utils.isTablet(this)) {
            ActivityInfo.SCREEN_ORIENTATION_SENSOR
        } else {
            ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
        }
    }

    private fun initializeToolbar() {
        setSupportActionBar(mToolbar)
    }

    override fun onStart() {
        super.onStart()
        getScopePresenter().init()
    }

    override fun onStop() {
        getScopePresenter().onStop()
        super.onStop()
    }

    abstract fun getScopePresenter(): ScopePresenter

    override fun showProgress(message: String) {
        showProgress.showProgress(message)
    }

    override fun dismissProgress() {
        showProgress.dismissProgress()
    }

    abstract fun getLayoutId(): Int
}