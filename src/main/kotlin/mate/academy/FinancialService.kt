package mate.academy

const val DEFAULT_VALUE = 1.0
const val USD_EUR = 0.93
const val USD_GBR = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.code} " +
                "to ${destination.code}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount((amount.amount * exchangeRate).toDouble())
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_GBR
            else -> DEFAULT_VALUE
        }
    }
}
