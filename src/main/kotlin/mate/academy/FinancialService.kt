package mate.academy

const val ACCOUNT_NUMBER_LENGTH = 10
const val CURRENCY_CODE_LENGTH = 3
const val RATE_USD_EUR = 0.93
const val RATE_USD_GBP = 0.82


@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(
            (accountNumber.length == ACCOUNT_NUMBER_LENGTH) &&
                    (accountNumber.all { it.isDigit() })
        )
        { "AccountNumber must be string of $ACCOUNT_NUMBER_LENGTH digits" }
    }
}

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "CurrencyAmount must be greater or equal 0" }
    }
}

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(
            (code.length == CURRENCY_CODE_LENGTH) &&
                    (code == code.uppercase())
        )
        { "CurrencyCode must be string of $CURRENCY_CODE_LENGTH uppercase letters" }
    }
}

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty())
        { "TransactionId must be not empty string" }
    }
}

class FinancialService {
    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ): String {
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.accountNumber} to" +
                " ${destination.accountNumber}. Transaction ID: ${transactionId.id}"
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
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> RATE_USD_EUR
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> RATE_USD_GBP
            else -> 1.0
        }
    }
}
