# Financial Service

In this task, you will enhance a `FinancialService` class by implementing two essential functionalities: **transferring funds between accounts** and **converting currency amounts**. 
The base code lays out the structure and provides some placeholder logic. The objective is to execute the logic within the `transferFunds` and `convertCurrency` methods and establish the required value classes.

## Task Requirements

1. **Transfer Funds Between Accounts**:
    - Implement the `transferFunds` method to simulate money transfer from a source to a destination account. This method requires **account numbers for both the source and destination, the amount to be transferred, the currency code of the amount,** and **a transaction ID**.
    - Upon completion, return a confirmation message summarizing the transaction, including details such as the amount transferred, currency code, and transaction ID.
    - In this task, interaction with an actual database isn't necessary; simulate the transaction logic and return the confirmation message.

2. **Convert Currency**:
    - Implement the `convertCurrency` method to simulate converting a given amount from one currency to another. This method takes **an amount, a source currency code,** and **a destination currency code** as inputs.
    Use the `getExchangeRate` method provided to determine the exchange rate between the two currencies. Then, calculate the converted amount and return it as a `CurrencyAmount`.
    - Placeholder logic exists within the `getExchangeRate` method, offering predefined rates for **USD to EUR** and **USD to GBP** conversions. Assume a 1:1 rate for any other currency conversions not explicitly defined.

3. **Creation of Inline Value Classes with Validation**:
    - `CurrencyAmount`: Represents a monetary amount. Ensure the amount is non-negative.
    - `CurrencyCode`: Represents a currency code. The code should be a 3-letter uppercase format (e.g., USD, EUR).
    - `AccountNumber`: Represents an account number. The number should be a 10-digit string.
    - `TransactionId`: Represents a transaction ID. Ensure the ID is not empty.

## Example

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
