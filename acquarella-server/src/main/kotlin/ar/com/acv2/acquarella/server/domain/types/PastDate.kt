package ar.com.acv2.acquarella.server.domain.types

import java.time.LocalDate

internal data class PastDate(val value: LocalDate) {
    init {
        require(value.isBefore(LocalDate.now())) { "Value must be a date in the past" }
    }
}