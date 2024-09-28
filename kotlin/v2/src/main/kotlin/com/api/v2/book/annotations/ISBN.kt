package com.api.v2.book.annotations

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
@Size(min=13, max=13)
annotation class ISBN(val regex: String = "\\d{13}")