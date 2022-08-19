package com.networkedassets.integrations.common

interface RequestConfig {
    val requestBaseUrl: String
    val connectionTimeout: Int
    val receiveTimeout: Int
}