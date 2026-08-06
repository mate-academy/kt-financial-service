package mate.academy

import mate.academy.model.AccountNumber
import mate.academy.model.CurrencyAmount
import mate.academy.model.CurrencyCode
import mate.academy.model.TransactionId

const val USD_EUR_RATE = 0.93
const val USD_GBP_RATE = 0.82
const val USD_DEFAULT_RATE = 1.0

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.number} to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(getExchangeRate(fromCurrency, toCurrency) * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_GBP_RATE
            else -> USD_DEFAULT_RATE
        }
    }
}
