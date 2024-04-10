package mate.academy

class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must be non-negative" }
    }
}

class CurrencyCode(val code: String) {
    init {
        require(code.matches("[A-Z]{3}".toRegex())) { "Invalid currency code format" }
    }
}

class AccountNumber(val number: String) {
    init {
        require(number.matches("\\d{10}".toRegex())) { "Invalid account number format" }
    }
}

class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction ID cannot be empty" }
    }
}


class FinancialService {
    companion object {
        private const val USD_TO_EUR_RATE = 0.93
        private const val USD_TO_GBP_RATE = 0.82
        private const val DEFAULT_EXCHANGE_RATE = 1.0
    }

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        require(amount.amount >= 0) { "Transfer amount must be non-negative" }
        require(source.number.matches("\\d{10}".toRegex())) { "Invalid source account number format" }
        require(destination.number.matches("\\d{10}".toRegex())) { "Invalid destination account number format" }
        require(currencyCode.code.matches("[A-Z]{3}".toRegex())) { "Invalid currency code format" }
        require(transactionId.id.isNotEmpty()) { "Transaction ID cannot be empty" }

        return ("Transferred ${amount.amount} ${currencyCode.code} from ${source.number} "
                + "to ${destination.number}. Transaction ID: ${transactionId.id}").trimMargin()
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        require(amount.amount >= 0) { "Amount to convert must be non-negative" }
        require(fromCurrency.code.matches("[A-Z]{3}".toRegex())) { "Invalid source currency code format" }
        require(toCurrency.code.matches("[A-Z]{3}".toRegex())) { "Invalid destination currency code format" }

        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        val convertedAmount = amount.amount * exchangeRate

        return CurrencyAmount(convertedAmount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> USD_TO_EUR_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> USD_TO_GBP_RATE
            else -> DEFAULT_EXCHANGE_RATE
        }
    }
}
