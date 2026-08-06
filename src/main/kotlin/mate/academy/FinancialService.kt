package mate.academy

const val RATE_USD_EUR = 0.93
const val RATE_USD_GBP = 0.82
const val DEFAULT_RATE = 1.0

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String = "Transferred ${amount.amount} ${currencyCode.code} from ${source.accountNumber} " +
            "to ${destination.accountNumber}. Transaction ID: ${transactionId.id}"

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount = CurrencyAmount(amount.amount.times(getExchangeRate(fromCurrency, toCurrency)))

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> RATE_USD_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> RATE_USD_GBP
            else -> DEFAULT_RATE
        }
    }
}
