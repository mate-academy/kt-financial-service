package mate.academy

import mate.academy.model.AccountNumber
import mate.academy.model.CurrencyAmount
import mate.academy.model.CurrencyCode
import mate.academy.model.TransactionId

const val RATE_USD_TO_EUR: Double = 0.93
const val RATE_USD_TO_GBP: Double = 0.82
const val DEFAULT_RATE: Double = 1.0

class FinancialService {

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} to " +
                "${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val rate = getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(amount.amount * rate)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> RATE_USD_TO_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> RATE_USD_TO_GBP
            else -> DEFAULT_RATE
        }
    }
}
