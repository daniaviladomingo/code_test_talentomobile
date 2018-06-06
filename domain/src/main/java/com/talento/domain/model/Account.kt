package com.talento.domain.model

data class Account(
    val accountBalanceInCents: Int,
    val accountCurrency: String,
    val accountId: Long,
    val accountName: String,
    val accountNumber: Int,
    val accountType: String,
    val alias: String,
    val isVisible: Boolean,
    val iban: String
)