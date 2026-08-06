package mate.academy

const val COMMISSION_USD_T0_EUR: Double = 0.93
const val COMMISSION_USD_T0_GBP: Double = 0.82
const val COMMISSION_GENERAL: Double = 1.0

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.number} to ${destination.number}. " +
                "Transaction ID: ${transactionId.identifier}"
    }

    fun convertCurrency(
        amount: CurrencyAmount, fromCurrency: CurrencyCode, toCurrency: CurrencyCode
    ): CurrencyAmount {
        getExchangeRate(fromCurrency, toCurrency)
        val money = getExchangeRate(fromCurrency, toCurrency)
        val convert = amount.amount.times(money)
        return CurrencyAmount(convert)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> COMMISSION_USD_T0_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> COMMISSION_USD_T0_GBP
            else -> COMMISSION_GENERAL
        }
    }
}
