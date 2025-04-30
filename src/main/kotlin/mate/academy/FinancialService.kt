package mate.academy

const val ON = 0.93
const val OE = 0.82
const val TEN = 10
class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.accountNumber} to ${destination.accountNumber}. " +
                "Transaction ID: ${transactionId.transactionId}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        val convertedValue = amount.amount * exchangeRate
        return CurrencyAmount(convertedValue)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> ON
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> OE
            else -> 1.0
        }
    }
}

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.length == TEN) { "Id must be length equal 10" }
        require(accountNumber.matches(Regex("^[0-9]{10}$"))) { "Account number must contain only digits" }
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Id must be greater or equal 0" }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("^[A-Z]{3}$"))) { "Code must consist from 3 uppercase letters (USD, EUR)" }
    }
}

@JvmInline
value class TransactionId(val transactionId: String) {
    init {
        require(transactionId.isNotEmpty()) { "Id must be not empty" }
    }
}
