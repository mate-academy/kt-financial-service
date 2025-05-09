package mate.academy.models

private const val CODELENGTH = 3

@JvmInline
    value class CurrencyCode(val code: String) {
        init {
            require(code.length == CODELENGTH) { "Currency code must be exactly 3 characters" }
            require(code.all { it.isUpperCase() }) { "Currency code  must contain only uppercase letters" }
        }
    }
