package mate.academy

const val CODE_LENGTH = 3
const val NUMBER_LENGTH = 10
const val USD_TO_EUR = 0.93
const val USD_TO_GBP = 0.82

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must be non-negative" }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code == code.uppercase()
                && code.length == CODE_LENGTH) {
            "The code should be a 3-letter uppercase format" }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.all { it.isDigit() }
                && number.length == NUMBER_LENGTH) {
            "The number should be a 10-digit string" }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "The ID must not be empty" }
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
        return CurrencyAmount(
            amount.amount * getExchangeRate(fromCurrency, toCurrency))
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
