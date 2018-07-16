package ar.com.acv2.acquarella.server.domain.types

internal abstract class NonEmptyString(text: String) {
    init {
        require(text.isNotBlank()) { "Text can't be empty or blank" }
    }
}