package mate.academy

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must can't be negative" }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("[A-Z]{3}"))) { "Currency code must be 3 chars length in uppercase" }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.matches(Regex("\\d{10}"))) { "Number must contain 10 digits only" }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.matches(Regex("^[A-Za-z0-9&&[^ ]]+$"))) { "Transaction Id can't be null or empty" }
    }
}
