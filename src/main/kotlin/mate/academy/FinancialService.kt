package mate.academy

const val USD = "USD"
const val EUR = "EUR"
const val GBP = "GBP"
const val COURSE_EUR = 0.93
const val COURSE_GBP = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred $amount $currencyCode from $source to $destination. Transaction ID: $transactionId"
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
            fromCurrency.code == USD && toCurrency.code == EUR -> COURSE_EUR
            fromCurrency.code == USD && toCurrency.code == GBP -> COURSE_GBP
            else -> 1.0
        }
    }
}
