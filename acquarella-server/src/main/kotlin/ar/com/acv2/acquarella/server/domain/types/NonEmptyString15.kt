package ar.com.acv2.acquarella.server.domain.types

internal data class NonEmptyString15(val text: String) : NonEmptyString(text) {
    init {
        require(text.length <= 15) { "Text can't be longer than 15 characters" }
    }
}