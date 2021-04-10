package com.example.ceria.data.local.entity

data class InstallmentEntity(
        var title: String,
        var amount: Int,
        var progress: Int
)

data class InstallmentHistory(
        var date: String,
        var listBilling: ArrayList<InstallmentDetailHistory>
)

data class InstallmentDetailHistory(
        var title: String,
        var desc: String,
        var amount: Int,
        var installment: Int
)

data class InstallmentCheckBox(
        var title: String,
        var desc: String,
        var amount: Int,
        var installment: Int
)