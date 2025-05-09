package mate.academy

const val CURR_CODE = 3
const val NUMBER_LENGTH = 10
const val EUR = 0.93
const val GBP = 0.82
@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must be non-negative." }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == CURR_CODE && code.all { it.isUpperCase() })
        { "Currency code must be a 3-letter uppercase code." }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == NUMBER_LENGTH && number.all { it.isDigit() })
        { "Account number must be a 10-digit string containing only numbers." }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction ID must not be empty." }
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
                "from ${source.number} to ${destination.number}. Transaction ID: ${transactionId.id}"
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
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> GBP
            else -> 1.0
        }
    }
}
