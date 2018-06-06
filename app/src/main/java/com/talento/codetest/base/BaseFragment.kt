package com.talento.codetest.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View? = null

        if (getLayoutId() != 0) {
            rootView = inflater.inflate(getLayoutId(), container, false)
        }

        return rootView
    }

    abstract fun getLayoutId(): Int
}