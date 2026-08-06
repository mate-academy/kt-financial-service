package mate.academy

const val USD_TO_EUR: Double = 0.93
const val USD_TO_GBP: Double = 0.82

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0.0) { "Amount must be non-negative" }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("^[A-Z]{3}$"))) {
            "Currency code must be 3 uppercase letters"
        }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.matches(Regex("^\\d{10}$"))) {
            "Account number must be a 10-digit string"
        }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotBlank()) {
            "Transaction ID must not be empty"
        }
    }
}

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.number} to ${destination.number}. " +
                "Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)

        val converted = amount.amount * exchangeRate

        return CurrencyAmount(converted)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP
            else -> 1.0
        }
    }
}
