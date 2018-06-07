package com.talento.codetest.ui

import com.google.gson.Gson
import com.talento.codetest.R
import com.talento.codetest.base.BaseActivity
import com.talento.domain.model.Account
import com.talento.data.RepositoryImp
import com.talento.data.file.FileDataSourceImp
import com.talento.data.file.model.mapper.FileMapper
import com.talento.domain.interactors.GetAccountSingleUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity(), MainContract.IView {

    lateinit var presenter: MainPresenter

    override fun getScopePresenter() = presenter

    private var allAccountListFragment: AccountListFragment? = null
    private var visibleAccountListFragment: AccountListFragment? = null

    override fun onStart() {
        presenter = MainPresenter(
                GetAccountSingleUseCase(
                        RepositoryImp(
                                FileDataSourceImp(
                                        FileMapper(),
                                        resources.openRawResource(R.raw.account),
                                        Gson()
                                ))),
                Schedulers.io(),
                AndroidSchedulers.mainThread())

        presenter.onAttachView(this)

        super.onStart()

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
