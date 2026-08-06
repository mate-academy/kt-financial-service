package mate.academy

const val COUNT_CODE = 10
const val CURRENCY_SYMBOL = 3
const val USD_EUR = 0.93
const val USD_GBP = 0.82

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} from" +
                " ${source.number} to ${destination.number}. Transaction ID: ${transactionId.id}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(exchangeRate.times(amount.amount))
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_GBP
            else -> 1.0
        }
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) {"Amount should be positive"}
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(isValidCurrencyCode(code)) {"Currency code must be 3 uppercase letters."}
    }

    companion object {
        private fun isValidCurrencyCode(code: String): Boolean {
            return code.length == CURRENCY_SYMBOL && code.all {it.isUpperCase() && it.isLetter()}
        }
    }
}

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(isValidAccountNumber(number)) {"AccountNumber must be 10 digits"}
    }
    companion object {
        private fun isValidAccountNumber(number: String): Boolean {
            return number.length == COUNT_CODE && number.all{it.isDigit()}
        }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(isValidTransactionId(id)) {"TransactionId must be more than 0"}
    }

    companion object {
        private fun isValidTransactionId(id: String): Boolean {
            return id.isNotBlank()
        }
    }
}
