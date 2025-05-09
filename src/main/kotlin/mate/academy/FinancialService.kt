package mate.academy

private const val NUMBER_LENGTH = 10
private const val CODE_LENGTH = 3
private const val EUR = 0.93
private const val GBR = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} to ${destination.number}. " +
                "Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(exchangeRate.times(amount.amount))
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> GBR
            else -> 1.0
        }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) {"Transaction id cannot be empty."}
    }

}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == CODE_LENGTH && code.all { it.isUpperCase()})
        {"The code should be a 3-letter uppercase format "}
    }

}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0)
        {"The amount should be non-negative"}
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == NUMBER_LENGTH && number.all { it.isDigit() })
        {"The number should be a 10-digit string"}
    }

}
