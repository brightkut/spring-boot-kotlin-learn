package com.example.demo.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

fun customObjectMapper(): ObjectMapper = jacksonObjectMapper()
        .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
        .registerModule(JavaTimeModule())
        //.registerModule(SimpleModule().addSerializer(ZonedDateTime::class.java, ZonedDateTimeSerializer(ISO_DATETIMEFORMATTER)))
        //.setTimeZone((TimeZone.getTimeZone(ZONE_ID)))
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

fun Any.asJsonString(): String = customObjectMapper()
        .writeValueAsString(this)