package mate.academy

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        //transfer logic
        return "Transferred ${amount.amount} ${currencyCode.code}" +
                " from ${source.number} to ${destination.number}." +
                " Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount = CurrencyAmount(amount.amount * getExchangeRate(fromCurrency, toCurrency))

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> 0.93
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> 0.82
            else -> 1.0
        }
    }
}
