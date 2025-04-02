package mate.academy

import mate.academy.data.AccountNumber
import mate.academy.data.CurrencyAmount
import mate.academy.data.CurrencyCode
import mate.academy.data.TransactionId

private const val USD_TO_EUR = 0.93
private const val USD_TO_GBP = 0.82
private const val DEFAULT_EXCHANGE = 1.0

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId,
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.accauntNumber} to " +
                "${destination.accauntNumber}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode,
    ): CurrencyAmount {
        return CurrencyAmount(amount.amount * getExchangeRate(fromCurrency, toCurrency))
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP
            else -> DEFAULT_EXCHANGE
        }
    }
}
