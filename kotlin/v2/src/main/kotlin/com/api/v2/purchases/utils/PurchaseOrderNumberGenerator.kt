package com.api.v2.purchases.utils

import java.math.BigInteger
import java.time.ZonedDateTime

class PurchaseOrderNumberGenerator {

    companion object {

        private var year = ZonedDateTime.now().year
        private var format = "${year}0000"
        private var response = BigInteger(format)

        fun generate(): BigInteger {
            response = response.plus(BigInteger.ONE)
            return response
        }

    }

}