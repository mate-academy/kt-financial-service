package mate.academy

import mate.academy.util.toSingleLine

private const val USD_TO_EUR_RATE = 0.93

private const val USD_TO_GBP_RATE = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String = """
        Transferred ${amount.amount} ${currencyCode.code} from ${source.number} to ${destination.number}. 
        Transaction ID: ${transactionId.id}
    """.toSingleLine()

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val convertedAmount = amount.amount * getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(convertedAmount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP_RATE
            else -> 1.0
        }
    }
}
