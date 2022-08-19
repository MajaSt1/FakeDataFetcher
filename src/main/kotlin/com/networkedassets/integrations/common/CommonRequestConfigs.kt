package com.networkedassets.integrations.common

data class FakeAPIRequestConfig(
    override val requestBaseUrl: String,
    override val connectionTimeout: Int = 2_000,
    override val receiveTimeout: Int = 2_000
): RequestConfig