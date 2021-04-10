package com.example.ceria.data.local.entity

data class BillingEntity(
    var date: String,
    var listBilling: ArrayList<BillingList>
)

data class BillingList(
    var title: String,
    var desc: String,
    var amount: Int
)