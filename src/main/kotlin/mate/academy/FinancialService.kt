package mate.academy

private const val DEFAULT_EXCHANGE_RATE = 1.0

private const val USD_EUR_RATE = 0.93

private const val USD_GBP_RATE = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.accountNumber} to ${destination.accountNumber}." +
                " Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val convertedAmount: Double =
            amount.amount * getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(convertedAmount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_GBP_RATE
            else -> DEFAULT_EXCHANGE_RATE
        }
    }
}
