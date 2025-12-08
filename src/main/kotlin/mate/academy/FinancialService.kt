package mate.academy

const val EXCHANGE_RATE_EUR = 0.93
const val EXCHANGE_RATE_USD = 0.82

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Currency amount must be non-negative" }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(
            code.matches(Regex("^[A-Z]{3}$")),
            { "Currency code must be 3 uppercase letters (e.g., USD, EUR)" })
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(
            number.matches(Regex("^\\d{10}$")),
            { "Account number must be exactly 10 digits" })
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotBlank(), { "Transaction ID cannot be empty or blank" })
    }
}

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} " +
                "to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(getExchangeRate(fromCurrency, toCurrency) * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> EXCHANGE_RATE_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> EXCHANGE_RATE_USD
            else -> 1.0
        }
    }
}
