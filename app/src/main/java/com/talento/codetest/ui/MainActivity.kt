package com.talento.codetest.ui

import com.talento.codetest.R
import com.talento.codetest.base.BaseActivity

class MainActivity : BaseActivity() {

//    @Inject
//    private lateinit var mainViewModel: MainViewModel
//
//    private var allAccountListFragment: AccountListFragment? = null
//    private var visibleAccountListFragment: AccountListFragment? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //initFragments()
//
//    }

    override fun getLayoutId() = R.layout.activity_main

//    private fun showAccounts(users: List<Account>) {
//        allAccountListFragment?.run {
//            updateAccountList(users)
//        }
//
//        visibleAccountListFragment?.run {
//            updateAccountList(users.filter { it.isVisible })
//        }
//    }

//    override fun getViewModel() = mainViewModel


//    private fun initFragments() {
//        allAccountListFragment = supportFragmentManager.findFragmentByTag(getString(R.string.fragment_all_accounts)) as AccountListFragment?
//        visibleAccountListFragment = supportFragmentManager.findFragmentByTag(getString(R.string.fragment_visible_accounts)) as AccountListFragment?
//    }
}
