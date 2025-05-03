package mate.academy.model

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("^(USD|EUR|GBP|UAH|JPY)$")))
        {"Code not matching the required format"}
    }
}
