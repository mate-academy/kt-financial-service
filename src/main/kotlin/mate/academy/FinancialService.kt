package mate.academy

import mate.academy.model.AccountNumber
import mate.academy.model.CurrencyAmount
import mate.academy.model.CurrencyCode
import mate.academy.model.TransactionId
import mate.academy.model.User

private const val DEFAULT_ALICE_AMOUNT = 1000.0

private const val DEFAULT_BOGDAN_AMOUNT = 2000.0

private const val DEFAULT_USD_TO_EURO_RATE = 0.93

private const val DEFAULT_USD_TO_GBR_RATE = 0.82

class FinancialService {
    val listOfUsers: MutableList<User> = mutableListOf()

    init {
        val alice: User = User("Alice", DEFAULT_ALICE_AMOUNT, AccountNumber("1234567890"))
        val bogdan: User = User("Bogdan", DEFAULT_BOGDAN_AMOUNT, AccountNumber("3456764567"))
        listOfUsers.add(alice)
        listOfUsers.add(bogdan)
    }

    fun transferFunds(
        source: AccountNumber,
        destination: AccountNumber,
        amount: CurrencyAmount,
        currencyCode: CurrencyCode,
        transactionId: TransactionId
    ) : String {
        val userSource: User? = getUserByBankAccount(listOfUsers, source)
        val userTarget: User? = getUserByBankAccount(listOfUsers, destination)
        userSource?.let { userSourceAccount ->
            userTarget?.let { target ->
                target.amount = target.amount.plus(amount.amount)
                userSourceAccount.amount = userSourceAccount.amount.minus(amount.amount)
            }
        }
        return "Transferred ${amount.amount} ${currencyCode.code} from ${source.accountNumber} " +
                "to ${destination.accountNumber}. " + "Transaction ID: ${transactionId.transactionId}"
    }

    fun convertCurrency(
        amount: CurrencyAmount,
        fromCurrency: CurrencyCode,
        toCurrency: CurrencyCode
    ): CurrencyAmount {
        println("Converted amount: ${amount.amount} ${toCurrency.code}")
        return CurrencyAmount(getExchangeRate(fromCurrency, toCurrency) * amount.amount)
    }

    private fun getExchangeRate(fromCurrency: CurrencyCode, toCurrency: CurrencyCode): Double {
        return when {
            fromCurrency.code == "USD" && toCurrency.code == "EUR" -> DEFAULT_USD_TO_EURO_RATE
            fromCurrency.code == "USD" && toCurrency.code == "GBP" -> DEFAULT_USD_TO_GBR_RATE
            else -> 1.0
        }
    }

    private fun getUserByBankAccount(listOfUsers: MutableList<User>, bankAccountNumber: AccountNumber): User? {
        return listOfUsers.find { it.accountNumber == bankAccountNumber }
    }
}
