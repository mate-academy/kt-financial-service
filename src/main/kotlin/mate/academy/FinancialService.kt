package mate.academy

import mate.academy.models.AccountNumber
import mate.academy.models.CurrencyAmount
import mate.academy.models.CurrencyCode
import mate.academy.models.TransactionId

const val EUR_RATE = 0.93
const val GBP_RATE = 0.82
const val DEFAULT_RATE = 1.0

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code.uppercase()} from ${source.accountNumber} " +
                "to ${destination.accountNumber}. Transaction ID: ${transactionId.transactionId}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(amount.amount * exchangeRate)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> GBP_RATE
            else -> DEFAULT_RATE
        }
    }
}
