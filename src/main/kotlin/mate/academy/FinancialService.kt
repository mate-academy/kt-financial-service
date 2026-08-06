package mate.academy

import mate.academy.model.AccountNumber
import mate.academy.model.CurrencyAmount
import mate.academy.model.CurrencyCode
import mate.academy.model.TransactionId

private const val EUR_RATE = 0.93
private const val GBR_RATE = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} " +
                "to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount, fromCurrency: CurrencyCode, toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(getExchangeRate(fromCurrency, toCurrency) * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> GBR_RATE
            else -> 1.0
        }
    }
}
