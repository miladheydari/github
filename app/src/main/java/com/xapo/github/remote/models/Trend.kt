package com.xapo.github.remote.models


data class Trend(
    val author: String?,
    val name: String?,
    val url: String?,
    val description: String?,
    val language: String?,
    val stars: Int?,
    val forks: Int?,
    val currentPeriodStars: Int?
)