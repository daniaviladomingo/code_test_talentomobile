package com.talento.data.file.model

import com.google.gson.annotations.SerializedName

data class File(@SerializedName("accounts") val accounts: List<AccountFile>,
                @SerializedName("failedAccountTypes")val failedAccountTypes: String,
                @SerializedName("returnCode")val returnCode: String)