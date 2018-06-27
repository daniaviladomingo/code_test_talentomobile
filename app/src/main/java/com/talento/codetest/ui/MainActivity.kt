package com.talento.codetest.ui

import android.os.Bundle
import com.talento.codetest.R
import com.talento.codetest.base.BaseActivity
import com.talento.codetest.di.components.DaggerActivityComponent
import com.talento.domain.model.Account
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.IView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun getScopePresenter() = presenter

    private var allAccountListFragment: AccountListFragment? = null
    private var visibleAccountListFragment: AccountListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
    }

    private fun initializeInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
//                .activityModule(activityModule)
                .build().inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        initFragments()
    }

    private fun initFragments() {
        allAccountListFragment = supportFragmentManager.findFragmentByTag(getString(R.string.fragment_all_accounts)) as AccountListFragment?
        visibleAccountListFragment = supportFragmentManager.findFragmentByTag(getString(R.string.fragment_visible_accounts)) as AccountListFragment?
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun showUsers(users: List<Account>) {
        allAccountListFragment?.run {
            updateAccountList(users)
        }

        visibleAccountListFragment?.run {
            updateAccountList(users.filter { it.isVisible })
        }
    }
}
