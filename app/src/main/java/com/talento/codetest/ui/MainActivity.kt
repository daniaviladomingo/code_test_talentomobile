package com.talento.codetest.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.talento.codetest.R
import com.talento.codetest.base.BaseActivity
import com.talento.codetest.di.activity.ActivityComponent
import com.talento.domain.model.Account
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainViewModule: MainViewModule

    private var allAccountListFragment: AccountListFragment? = null
    private var visibleAccountListFragment: AccountListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragments()

        mainViewModule = ViewModelProviders.of(this, viewModelFactory).get(MainViewModule::class.java)

        mainViewModule.listAccount?.observe(this, Observer {
            showAccounts(it!!)
        })
    }

    override fun getLayoutId() = R.layout.activity_main

    private fun showAccounts(users: List<Account>) {
        allAccountListFragment?.run {
            updateAccountList(users)
        }

        visibleAccountListFragment?.run {
            updateAccountList(users.filter { it.isVisible })
        }
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun initFragments() {
        allAccountListFragment = supportFragmentManager.findFragmentByTag(getString(R.string.fragment_all_accounts)) as AccountListFragment?
        visibleAccountListFragment = supportFragmentManager.findFragmentByTag(getString(R.string.fragment_visible_accounts)) as AccountListFragment?
    }
}
