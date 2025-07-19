package mate.academy

const val ZERO : Int = 0
const val ONE: Double = 1.0
const val ACCOUNT_NUMBER_PATTERN: String = "^\\d{10}$"
const val CURRENCY_CODE_PATTERN: String = "^[A-Z]{3}$"
const val USD: String = "USD"
const val EUR: String = "EUR"
const val GBP: String = "GBP"
const val USD_TO_EUR: Double = 0.93
const val USD_TO_GBP: Double = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number}" +
         " to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(getExchangeRate(fromCurrency,
            toCurrency) * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode,
                                toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == USD
                    && toCurrency.code == EUR -> USD_TO_EUR
            fromCurrency.code == USD
                    && toCurrency.code == GBP -> USD_TO_GBP
            else -> ONE
        }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(Regex(CURRENCY_CODE_PATTERN).matches(code)) {
            "Invalid code format"
        }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) {
            "Invalid transaction id"
        }
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= ZERO) {
            "Invalid currency amount"
        }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(Regex(ACCOUNT_NUMBER_PATTERN).matches(number)) {
            "Invalid account number"
        }
    }
}
