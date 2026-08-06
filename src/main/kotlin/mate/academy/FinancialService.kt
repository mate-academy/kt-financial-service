package mate.academy

import mate.academy.value.AccountNumber
import mate.academy.value.CurrencyAmount
import mate.academy.value.CurrencyCode
import mate.academy.value.TransactionId

const val USD_EUR_RATE = 0.93
const val USD_GBP_RATE = 0.82
const val DEFAULT_RATE = 1.0

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.accountNumber} to ${destination.accountNumber}. " +
                "Transaction ID: ${transactionId.transactionId}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(
            amount.amount * getExchangeRate(fromCurrency, toCurrency)
        )
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_GBP_RATE
            else -> DEFAULT_RATE
        }
    }
}
