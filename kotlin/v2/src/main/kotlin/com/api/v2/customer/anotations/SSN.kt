package com.api.v2.customer.anotations

import kotlin.annotation.AnnotationRetention
import kotlin.annotation.AnnotationTarget

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
annotation class SSN(val regex: String = "\\d{9}")