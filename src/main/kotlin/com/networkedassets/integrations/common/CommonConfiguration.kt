package com.networkedassets.integrations.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val objectMapper: ObjectMapper = ObjectMapper().registerModule(
    KotlinModule.Builder()
        .build()
)

fun <T> logger(clazz: Class<T>): Logger = LoggerFactory.getLogger(clazz)
