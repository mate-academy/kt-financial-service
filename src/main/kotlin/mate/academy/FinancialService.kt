package mate.academy

const val USD = "USD"
const val EUR = "EUR"
const val GBP = "GBP"
const val RATE_USD_TO_EUR = 0.93
const val RATE_USD_TO_GBP = 0.82
const val DEFAULT_RATE = 1.0
const val ZERO = 0
const val ACCOUNT_PATTERN = "[0-9]{10}"
const val CURRENCY_CODE_PATTERN = "[A-Z]{3}"

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.number} " +
                "to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        return CurrencyAmount(getExchangeRate(fromCurrency, toCurrency) * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == USD && toCurrency.code == EUR -> RATE_USD_TO_EUR
            fromCurrency.code == USD && toCurrency.code == GBP -> RATE_USD_TO_GBP
            else -> DEFAULT_RATE
        }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.matches(Regex(ACCOUNT_PATTERN)))
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= ZERO)
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex(CURRENCY_CODE_PATTERN)))
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(!id.isEmpty())
    }
}
