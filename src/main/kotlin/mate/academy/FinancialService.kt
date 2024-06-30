package mate.academy

const val EXCHANGE_RATE_USD_TO_EUR = 0.93
const val EXCHANGE_RATE_USD_TO_GBP = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) = "Transferred ${amount.amount} ${currencyCode.code} " +
            "from ${source.accountNumber} to ${destination.accountNumber}. " +
            "Transaction ID: ${transactionId.transactionId}"

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        val convertedAmount = amount.amount.times(exchangeRate)
        return CurrencyAmount(convertedAmount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> EXCHANGE_RATE_USD_TO_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> EXCHANGE_RATE_USD_TO_GBP
            else -> 1.0
        }
    }
}
