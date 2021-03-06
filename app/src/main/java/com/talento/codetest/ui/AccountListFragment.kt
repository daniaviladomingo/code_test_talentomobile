package com.talento.codetest.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.talento.codetest.R
import com.talento.codetest.base.BaseFragment
import com.talento.codetest.ui.adapter.AccountListAdapter
import com.talento.domain.model.Account
import kotlinx.android.synthetic.main.fragment_account_list.*

class AccountListFragment: BaseFragment() {

    private val accountList = mutableListOf<Account>()
    private lateinit var accountListAdapter: AccountListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountListAdapter = AccountListAdapter(accountList)

        account_recyclerview.setHasFixedSize(true)
        account_recyclerview.adapter = accountListAdapter
        account_recyclerview.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        account_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    fun updateAccountList(accountList: List<Account>) {
        this.accountList.run {
            clear()
            addAll(accountList)
        }

        activity?.runOnUiThread {
            accountListAdapter.notifyDataSetChanged()
        }
    }

    override fun getLayoutId() = R.layout.fragment_account_list
}