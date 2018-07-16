package ar.com.acv2.acquarella.server.domain.types

internal data class MemberCode(val value: String) : NonEmptyString(value) {
    init {
        require(value.trim().length == 32) { "Member's code must have 32 characters" }
    }
}