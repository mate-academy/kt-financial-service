package mate.academy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class FinancialServiceTest {

    private val financialService = FinancialService()

    @Test
    fun transferFunds_ValidInput_SuccessfulTransfer() {
        // given
        val source = AccountNumber("1234567890")
        val destination = AccountNumber("0987654321")
        val amount = CurrencyAmount(100.0)
        val currencyCode = CurrencyCode("USD")
        val transactionId = TransactionId("txn123")

        // when
        val result = financialService.transferFunds(source, destination, amount, currencyCode, transactionId)

        // then
        Assertions.assertEquals("Transferred 100.0 USD from 1234567890 to 0987654321. Transaction ID: txn123", result)
    }

    @Test
    fun transferFunds_InvalidSourceAccount_ThrowsException() {
        // given
        val invalidSource = "12345" // Not matching the required format

        // when & then
        val executable = Executable { AccountNumber(invalidSource) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_InvalidDestinationAccount_ThrowsException() {
        // given
        val invalidDestination = "12345" // Not matching the required format

        // when & then
        val executable = Executable { AccountNumber(invalidDestination) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_NegativeTransferAmount_ThrowsException() {
        // given
        val negativeAmount = -100.0

        // when & then
        val executable = Executable { CurrencyAmount(negativeAmount) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_InvalidCurrencyCode_ThrowsException() {
        // given
        val invalidCurrencyCode = "US" // Not matching the required format

        // when & then
        val executable = Executable { CurrencyCode(invalidCurrencyCode) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_InvalidTransactionId_ThrowsException() {
        // given
        val emptyTransactionId = "" // Not matching the required format

        // when & then
        val executable = Executable { TransactionId(emptyTransactionId) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_SameSourceAndDestination_ExpectedBehavior() {
        // given
        val sourceAndDestination = AccountNumber("1234567890")
        val amount = CurrencyAmount(100.0)
        val currencyCode = CurrencyCode("USD")
        val transactionId = TransactionId("txn123")

        // when
        val result = financialService.transferFunds(
            sourceAndDestination,
            sourceAndDestination,
            amount,
            currencyCode,
            transactionId
        )

        // then
        Assertions.assertEquals("Transferred 100.0 USD from 1234567890 to 1234567890. Transaction ID: txn123", result)
    }

    @Test
    fun convertCurrency_ValidInput_SuccessfulConversion() {
        // given
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("USD")
        val toCurrency = CurrencyCode("EUR")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        Assertions.assertEquals(93.0, result.amount)
    }

    @Test
    fun convertCurrency_InvalidFromCurrencyCode_ThrowsException() {
        // given
        val invalidFromCurrency = "US" // Not matching the required format

        // when & then
        val executable = Executable { CurrencyCode(invalidFromCurrency) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun convertCurrency_InvalidToCurrencyCode_ThrowsException() {
        // given
        val invalidToCurrency = "EU" // Not matching the required format

        // when & then
        val executable = Executable { CurrencyCode(invalidToCurrency) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun convertCurrency_NegativeAmount_ThrowsException() {
        // given
        val negativeAmount = -100.0

        // when & then
        val executable = Executable { CurrencyAmount(negativeAmount) }
        Assertions.assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_USDtoEUR() {
        // given
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("USD")
        val toCurrency = CurrencyCode("EUR")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        Assertions.assertEquals(93.0, result.amount)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_USDtoGBP() {
        // given
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("USD")
        val toCurrency = CurrencyCode("GBP")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        Assertions.assertEquals(82.0, result.amount)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_UnsupportedPair() {
        // given
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("EUR")
        val toCurrency = CurrencyCode("JPY")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        Assertions.assertEquals(100.0, result.amount) // Expecting a 1:1 conversion rate for unsupported pairs
    }

    // Tests for CurrencyAmount
    @Test
    fun currencyAmount_ValidAmount_Success() {
        Assertions.assertDoesNotThrow { CurrencyAmount(100.0) }
    }

    @Test
    fun currencyAmount_NegativeAmount_ThrowsException() {
        assertThrows<IllegalArgumentException> { CurrencyAmount(-100.0) }
    }

    @Test
    fun currencyAmount_ZeroAmount_Success() {
        Assertions.assertDoesNotThrow { CurrencyAmount(0.0) }
    }

    // Tests for CurrencyCode
    @Test
    fun currencyCode_ValidCode_Success() {
        Assertions.assertDoesNotThrow { CurrencyCode("USD") }
    }

    @Test
    fun currencyCode_InvalidCode_ThrowsException() {
        assertThrows<IllegalArgumentException> { CurrencyCode("usd") } // not uppercase
        assertThrows<IllegalArgumentException> { CurrencyCode("EU") }  // not 3 letters
        assertThrows<IllegalArgumentException> { CurrencyCode("EURO") } // more than 3 letters
    }

    // Tests for AccountNumber
    @Test
    fun accountNumber_ValidNumber_Success() {
        Assertions.assertDoesNotThrow { AccountNumber("1234567890") }
    }

    @Test
    fun accountNumber_InvalidNumberFormat_ThrowsException() {
        assertThrows<IllegalArgumentException> { AccountNumber("123456789") }  // less than 10 digits
        assertThrows<IllegalArgumentException> { AccountNumber("12345678901") } // more than 10 digits
        assertThrows<IllegalArgumentException> { AccountNumber("12345abcde") }  // contains letters
    }

    // Tests for TransactionId
    @Test
    fun transactionId_ValidId_Success() {
        Assertions.assertDoesNotThrow { TransactionId("txn123") }
    }

    @Test
    fun transactionId_EmptyId_ThrowsException() {
        assertThrows<IllegalArgumentException> { TransactionId("") }
    }
}
