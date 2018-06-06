package com.talento.codetest.base

import android.app.ProgressDialog
import com.talento.codetest.base.progress.IShowProgress

class ShowProgressImp(var progressDialog: ProgressDialog): IShowProgress {

    override fun showProgress(message: String) {
        progressDialog.run {
            setMessage(message)
            show()
        }
    }

    override fun dismissProgress() {
        progressDialog.dismiss()
    }
}