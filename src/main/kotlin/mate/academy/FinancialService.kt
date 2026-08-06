package mate.academy

// Константи перенесені в окремий об'єкт для доступу в інших класах
object Constants {
    const val CURRENCY_CODE_LENGTH = 3
    const val ACCOUNT_NUMBER_LENGTH = 10
    const val USD_TO_EUR_RATE = 0.93
    const val USD_TO_GBP_RATE = 0.82
    const val DEFAULT_RATE = 1.0
}

class FinancialService {

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.number} to ${destination.number}." +
                " Transaction ID: ${transactionId.id}"
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
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> Constants.USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> Constants.USD_TO_GBP_RATE
            else -> Constants.DEFAULT_RATE
        }
    }
}

data class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must be non-negative." }
    }
}

data class CurrencyCode(val code: String) {
    init {
        require(code.length == Constants.CURRENCY_CODE_LENGTH && code.all { it.isUpperCase() }) {
            "Currency code must be a 3-letter uppercase code." }
    }
}

data class AccountNumber(val number: String) {
    init {
        require(number.length == Constants.ACCOUNT_NUMBER_LENGTH && number.all { it.isDigit() }) {
            "Account number must be a 10-digit string." }
    }
}

data class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction ID must not be empty." }
    }
}
