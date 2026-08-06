package mate.academy

class FinancialService {
    companion object {
        const val ACCOUNT_NUMBER_LENGTH = 10
        const val CURRENCY_CODE_LENGTH = 3
        const val MIN_ALLOW_VALUE = 0.0
        const val UNCHAGED_RATE = 1.0
        const val USD_TO_EUR_RATE = 0.93
        const val USD_TO_GBP_RATE = 0.82
    }
    @JvmInline
    value class AccountNumber(val number: String) {
        init {
            require(number.length == ACCOUNT_NUMBER_LENGTH) { "Account number must " +
                    "be exactly 10 digits." }
            require(number.all { it.isDigit() }) { "Account number must contain only digits." }
        }
    }

    @JvmInline
    value class CurrencyAmount(val amount: Double) {
        init {
            require(amount >= MIN_ALLOW_VALUE) { "Amount must be non-negative." }
        }
    }

    @JvmInline
    value class CurrencyCode(val code: String) {
        init {
            require(code.length == CURRENCY_CODE_LENGTH) { "Currency code " +
                    "must be exactly 3 characters." }
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
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP_RATE
            else -> UNCHAGED_RATE
        }
    }
}
