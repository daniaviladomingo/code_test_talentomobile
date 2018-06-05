package com.talento.data.model
import com.google.gson.annotations.SerializedName

data class AccountApi(
        @SerializedName("accountBalanceInCents") val accountBalanceInCents: Int,
        @SerializedName("accountCurrency") val accountCurrency: String,
        @SerializedName("accountId") val accountId: Int,
        @SerializedName("accountName") val accountName: String,
        @SerializedName("accountNumber") val accountNumber: Int,
        @SerializedName("accountType") val accountType: String,
        @SerializedName("alias") val alias: String,
        @SerializedName("isVisible") val isVisible: Boolean,
        @SerializedName("iban") val iban: String
)