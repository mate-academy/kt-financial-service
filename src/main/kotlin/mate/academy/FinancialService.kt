package mate.academy
const val NUM1 = 0.93
const val NUM2 = 0.82
class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return  "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.number} to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency = fromCurrency, toCurrency = toCurrency)
        return CurrencyAmount(exchangeRate.times(amount.amount))
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> NUM1
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> NUM2
            else -> 1.0
        }
    }
}

@JvmInline
value class AccountNumber(val number: String){
    companion object {
        const val NUMBER_LENGTH: Int = 10
    }
    init {
        require(number.length == NUMBER_LENGTH && number.all { it.isDigit() })
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0)
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    companion object {
        const val CODE_LENGTH: Int = 3
    }
    init {
        require(code.length == CODE_LENGTH && code.toCharArray().all { it.isUpperCase() })
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty())
    }
}
