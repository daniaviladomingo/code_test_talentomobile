package com.talento.codetest.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.talento.codetest.R
import com.talento.domain.model.Account
import kotlinx.android.synthetic.main.item_account.view.*

class AccountListAdapter(private var accountList: List<Account>): RecyclerView.Adapter<AccountListAdapter.AccountHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AccountHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false))

    override fun getItemCount() = accountList.size

    override fun onBindViewHolder(holder: AccountHolder, position: Int) = holder.bin(accountList[position])

    inner class AccountHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bin(account: Account){
            account.run {
                itemView.accountName.text = accountName
                itemView.iban.text = iban
                itemView.balance.text = "$accountBalanceInCents"
            }
        }
    }
}