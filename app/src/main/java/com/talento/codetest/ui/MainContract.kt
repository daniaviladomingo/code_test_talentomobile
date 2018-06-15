package com.talento.codetest.ui

import com.talento.codetest.base.BaseView
import com.talento.codetest.base.ScopePresenter
import com.talento.domain.model.Account

interface MainContract {
    interface IView: BaseView {
        fun showUsers(users: List<Account>)
    }

    interface IPresenter: ScopePresenter
}