package ar.com.acv2.acquarella.server.domain.types

internal data class NonEmptyString50(val text: String) : NonEmptyString(text) {
    init {
        require(text.length <= 50) { "Text can't be longer than 50 characters" }
    }
}