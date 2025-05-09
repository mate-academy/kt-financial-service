package mate.academy

import mate.academy.models.AccountNumber
import mate.academy.models.CurrencyAmount
import mate.academy.models.CurrencyCode
import mate.academy.models.TransactionId

private const val USDTOEUR = 0.93

private const val USDTOGBR = 0.82

private const val DEFAULTEXCHANGE = 1.0

class FinancialService {

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.amountNumber} " +
                "to ${destination.amountNumber}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        val convertedAmount = amount.amount * exchangeRate
        return CurrencyAmount(convertedAmount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USDTOEUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USDTOGBR
            else -> DEFAULTEXCHANGE
        }
    }
}
