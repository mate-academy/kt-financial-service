package mate.academy

const val USDEUR =  0.93
const val USDGBP = 0.82

class FinancialService {
    @JvmInline
    value class AccountNumber(val accountNumber: String) {
        init {
            require(accountNumber.matches(Regex("^\\d{10}\$")))
        }
    }

    @JvmInline
    value class CurrencyAmount(val amount: Double) {
        init {
            require(amount >= 0)
        }
    }

    @JvmInline
    value class CurrencyCode(val code: String) {
        init {
            require(code.matches(Regex("^[A-Z]{3}\$")))
        }
    }

    @JvmInline
    value class TransactionId(val id: String) {
        init {
            require(!id.isEmpty())
        }
    }

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.accountNumber}" +
                " to ${destination.accountNumber}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(amount.amount * getExchangeRate(fromCurrency, toCurrency))
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USDEUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USDGBP
            else -> 1.0
        }
    }
}
