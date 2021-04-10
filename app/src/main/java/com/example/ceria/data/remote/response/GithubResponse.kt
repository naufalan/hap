package com.example.ceria.data.remote.response


data class GithubResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)