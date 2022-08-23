package com.networkedassets.integrations.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val objectMapper: ObjectMapper = jacksonObjectMapper()
fun <T> logger(clazz: Class<T>): Logger = LoggerFactory.getLogger(clazz)