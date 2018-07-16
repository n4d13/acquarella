package ar.com.acv2.acquarella.server.domain.types

internal data class Id(val value: Int) {
    init {
        require(value > 0) { "Id must be greater than zero" }
    }
}