package com.gamevault.common

data class AppPrefs(
    val showRatings: Boolean    = true,
    val showMetacritic: Boolean = true,
    val isCompact: Boolean      = false,
    val language: String        = "Русский 🇷🇺",
    val adultFilter: Boolean    = false,
    val autoRefresh: Boolean    = true,
    val cacheEnabled: Boolean   = true,
    val notifications: Boolean  = true
)
