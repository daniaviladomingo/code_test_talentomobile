package com.talento.codetest.ui

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.talento.codetest.ui.adapter.AccountListAdapter
import com.talento.domain.model.Account

@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, listCrew: List<Account>) {
    (recyclerView.adapter as AccountListAdapter).replaceData(listCrew)
}