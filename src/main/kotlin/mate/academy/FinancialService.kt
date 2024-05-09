package mate.academy

class FinancialService {

    companion object {
        private const val DEFAULT_RATE = 1.0

        private const val RATE_USD_EUR = 0.93

        private const val RATE_USD_GBP = 0.82
    }

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
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> RATE_USD_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> RATE_USD_GBP
            else -> DEFAULT_RATE
        }
    }
}
