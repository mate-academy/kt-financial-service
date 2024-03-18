# Financial Service


In this task, you will enhance a `FinancialService` class by implementing two core functionalities: transferring funds between accounts and converting currency amounts. 
The base code provides the structure and some placeholder logic. 
Your goal is to implement the logic within the `transferFunds` and `convertCurrency` methods, and create required value classes.

### Task Requirements

1. **Transfer Funds Between Accounts**:
    - Implement the `transferFunds` method to simulate transferring money from a source account to a destination account. This method accepts account numbers for both the source and destination, the amount to be transferred, the currency code of the amount, and a transaction ID.
    - Your implementation should return a confirmation message summarizing the transaction, including the amount transferred, the currency code, and the transaction ID.
    - For this task, you do not need to interact with a real database; simply simulate the transaction logic and return the confirmation message.

2. **Convert Currency**:
    - Implement the `convertCurrency` method to simulate converting a given amount from one currency to another. This method takes an amount, a source currency code, and a destination currency code as inputs.
    - Use the provided `getExchangeRate` method to determine the exchange rate between the two currencies. Then, calculate the converted amount and return it as a `CurrencyAmount`.
    - The `getExchangeRate` method includes placeholder logic with predefined rates for USD to EUR and USD to GBP conversions. Assume a 1:1 rate for any other currency conversions not explicitly defined.

3. **Create the following inline value classes with validation**:
    - `CurrencyAmount`: Represents a monetary amount. Should ensure the amount is non-negative.
    - `CurrencyCode`: Represents a currency code. Should be a 3-letter uppercase code (e.g., USD, EUR).
    - `AccountNumber`: Represents an account number. Should be a 10-digit string.
    - `TransactionId`: Represents a transaction ID. Should ensure the ID is not empty.

### Example Usage

```kotlin
val financialService = FinancialService()
val transferMessage = financialService.transferFunds(
    source = AccountNumber("1234567890"),
    destination = AccountNumber("0987654321"),
    amount = CurrencyAmount(100.0),
    currencyCode = CurrencyCode("USD"),
    transactionId = TransactionId("TX12345")
)
println(transferMessage)
// Expected output: "Transferred 100.0 USD from 1234567890 to 0987654321. Transaction ID: TX12345"

val convertedAmount = financialService.convertCurrency(
    amount = CurrencyAmount(100.0),
    fromCurrency = CurrencyCode("USD"),
    toCurrency = CurrencyCode("EUR")
)
println("Converted amount: ${convertedAmount.amount} EUR")
// Expected output: "Converted amount: 93.0 EUR"
```
