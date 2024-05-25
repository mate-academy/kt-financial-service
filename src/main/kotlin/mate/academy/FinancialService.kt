package mate.academy

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) = "Transferred $amount $currencyCode from $source to $destination. Transaction ID: $transactionId"

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ) = CurrencyAmount(getExchangeRate(fromCurrency, toCurrency) * amount.amount)

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode) = when {
        fromCurrency.code == "USD" && toCurrency.code == "EUR" -> 0.93
        fromCurrency.code == "USD" && toCurrency.code == "GBP" -> 0.82
        else -> 1.0
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount is non-negative" }
    }

    override fun toString() = amount.toString()
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("[A-Z]{3}"))) { "Code should be a 3-letter uppercase format" }
    }

    override fun toString() = code
}

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.matches(Regex("\\d{10}"))) { "Account number should be 10 digit string" }
    }

    override fun toString() = accountNumber
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction Id can't be empty" }
    }

    override fun toString() = id
}
