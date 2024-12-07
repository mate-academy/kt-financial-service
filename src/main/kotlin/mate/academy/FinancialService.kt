package mate.academy

class FinancialService {
    @JvmInline
    value class AccountNumber(val number: String) {
        init {
            require(number.length == 10) { "Account number must be exactly 10 digits." }
            require(number.all { it.isDigit() }) { "Account number must contain only digits." }
        }
    }

    @JvmInline
    value class CurrencyAmount(val amount: Double) {
        init {
            require(amount >= 0) { "Amount must be non-negative." }
        }
    }

    @JvmInline
    value class CurrencyCode(val code: String) {
        init {
            require(code.length == 3) { "Currency code must be exactly 3 characters." }
            require(code.all { it.isUpperCase() }) { "Currency code must be uppercase." }
            require(code.all { it.isLetter() }) { "Currency code must contain only letters." }
        }
    }

    @JvmInline
    value class TransactionId(val id: String) {
        init {
            require(id.isNotEmpty()) { "Transaction ID cannot be empty." }
        }
    }

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} to " +
                "${destination.number}. Transaction ID: ${transactionId.id}"
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
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> 0.93
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> 0.82
            else -> 1.0
        }
    }
}
