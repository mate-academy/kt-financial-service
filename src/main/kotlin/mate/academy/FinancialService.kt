package mate.academy

const val FROM_USD_TO_EUR_RATE = 0.93
const val FROM_USD_TO_GBP_RATE = 0.82
const val DEFAULT_RATE = 1.0

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
        return CurrencyAmount(amount.amount * getExchangeRate(fromCurrency, toCurrency))
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> FROM_USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> FROM_USD_TO_GBP_RATE
            else -> DEFAULT_RATE
        }
    }
}
