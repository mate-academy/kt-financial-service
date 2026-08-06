package mate.academy

private const val MIN_AMOUNT = 0.0
private const val CURRENCY_CODE_LENGTH = 3
private const val ACCOUNT_NUMBER_LENGTH = 10
private const val DEFAULT_RATE = 1.0
private const val USD_TO_EUR_RATE = 0.93
private const val USD_TO_GBP_RATE = 0.82

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= MIN_AMOUNT) { "Amount must be non-negative." }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == CURRENCY_CODE_LENGTH && code.uppercase() == code)
        { "Currency code must be a 3-letter uppercase string." }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == ACCOUNT_NUMBER_LENGTH && number.all { it.isDigit() })
        { "Account number must be a 10-digit string." }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction ID cannot be empty." }
    }
}

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId): String {
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
        val convertedAmount = amount.amount * exchangeRate
        return CurrencyAmount(convertedAmount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP_RATE
            else -> DEFAULT_RATE
        }
    }
}
