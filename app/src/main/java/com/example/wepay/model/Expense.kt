package com.example.wepay.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Expense(
    val  expenseName: String,
    val totalAmount: Int,
    val expenseType: Int,
)
