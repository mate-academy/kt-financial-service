package mate.academy

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        if (!accountNumber.matches(Regex("\\d{10}"))) {
            throw IllegalArgumentException("Invalid account number format. Must be a 10 digit string.")
        }
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Currency amount must be non-negative.")
        }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        if (!code.matches(Regex("[A-Z]{3}"))) {
            throw IllegalArgumentException("Invalid currency code format. Must be 3 uppercase letters.")
        }
    }
}

@JvmInline
value class TransactionId(val transactionId: String) {
    init {
        if (transactionId.isEmpty()) {
            throw IllegalArgumentException("Transaction ID cannot be empty.")
        }
    }
}



class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        return "Transferred ${amount.amount} ${currencyCode.code} " +
                "from ${source.accountNumber} to ${destination.accountNumber}. " +
                "Transaction ID: ${transactionId.transactionId}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        val exchangeRate = getExchangeRate(fromCurrency, toCurrency)
        return CurrencyAmount(exchangeRate * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        // Placeholder exchange rate - in a real application, you'd fetch this from a financial API
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> 0.93
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> 0.82
            else -> 1.0
        }
    }
}
