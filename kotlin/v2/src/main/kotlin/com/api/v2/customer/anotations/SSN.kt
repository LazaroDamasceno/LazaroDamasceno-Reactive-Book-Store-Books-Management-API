package com.api.v2.customer.anotations

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlin.annotation.AnnotationRetention
import kotlin.annotation.AnnotationTarget

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE
)
@NotBlank
@Size(min=9, max=9)
annotation class SSN(val regex: String = "\\d{9}")