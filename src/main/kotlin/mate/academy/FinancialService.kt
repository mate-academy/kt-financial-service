package mate.academy

import mate.academy.value.AccountNumber
import mate.academy.value.CurrencyAmount
import mate.academy.value.CurrencyCode
import mate.academy.value.TransactionId

class FinancialService {
    companion object{
        const val USD_TO_EUR_RATE = 0.93
        const val USD_TO_GBP_RATE = 0.82
        private const val DEFAULT = 1.0
    }
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} " +
                "to ${destination.number}." + " Transaction ID: ${transactionId.transactionId}"

    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        val exchangedAmount = exchangeRate * amount.amount
        return CurrencyAmount(exchangedAmount)

    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {

        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP_RATE
            else -> DEFAULT
        }
    }
}
