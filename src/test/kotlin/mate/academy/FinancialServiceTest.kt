package mate.academy

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class FinancialServiceTest {

    private val financialService = FinancialService()

    @Test
    fun transferFunds_ValidInput_SuccessfulTransfer() {
        // given
        val source = FinancialService.AccountNumber("1234567890")
        val destination = FinancialService.AccountNumber("0987654321")
        val amount = FinancialService.CurrencyAmount(100.0)
        val currencyCode = FinancialService.CurrencyCode("USD")
        val transactionId = FinancialService.TransactionId("txn123")

        // when
        val result = financialService.transferFunds(source, destination, amount, currencyCode, transactionId)

        // then
        assertEquals("Transferred 100.0 USD from 1234567890 to 0987654321. Transaction ID: txn123", result)
    }

    @Test
    fun transferFunds_InvalidSourceAccount_ThrowsException() {
        // given
        val invalidSource = "12345" // Not matching the required format

        // when & then
        val executable = Executable { FinancialService.AccountNumber(invalidSource) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_InvalidDestinationAccount_ThrowsException() {
        // given
        val invalidDestination = "12345" // Not matching the required format

        // when & then
        val executable = Executable { FinancialService.AccountNumber(invalidDestination) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_NegativeTransferAmount_ThrowsException() {
        // given
        val negativeAmount = -100.0

        // when & then
        val executable = Executable { FinancialService.CurrencyAmount(negativeAmount) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_InvalidCurrencyCode_ThrowsException() {
        // given
        val invalidCurrencyCode = "US" // Not matching the required format

        // when & then
        val executable = Executable { FinancialService.CurrencyCode(invalidCurrencyCode) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_InvalidTransactionId_ThrowsException() {
        // given
        val emptyTransactionId = "" // Not matching the required format

        // when & then
        val executable = Executable { FinancialService.TransactionId(emptyTransactionId) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun transferFunds_SameSourceAndDestination_ExpectedBehavior() {
        // given
        val sourceAndDestination = FinancialService.AccountNumber("1234567890")
        val amount = FinancialService.CurrencyAmount(100.0)
        val currencyCode = FinancialService.CurrencyCode("USD")
        val transactionId = FinancialService.TransactionId("txn123")

        // when
        val result = financialService.transferFunds(
            sourceAndDestination,
            sourceAndDestination,
            amount,
            currencyCode,
            transactionId
        )

        // then
        assertEquals("Transferred 100.0 USD from 1234567890 to 1234567890. Transaction ID: txn123", result)
    }

    @Test
    fun convertCurrency_ValidInput_SuccessfulConversion() {
        // given
        val amount = FinancialService.CurrencyAmount(100.0)
        val fromCurrency = FinancialService.CurrencyCode("USD")
        val toCurrency = FinancialService.CurrencyCode("EUR")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        assertEquals(93.0, result.amount)
    }

    @Test
    fun convertCurrency_InvalidFromCurrencyCode_ThrowsException() {
        // given
        val invalidFromCurrency = "US" // Not matching the required format

        // when & then
        val executable = Executable { FinancialService.CurrencyCode(invalidFromCurrency) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun convertCurrency_InvalidToCurrencyCode_ThrowsException() {
        // given
        val invalidToCurrency = "EU" // Not matching the required format

        // when & then
        val executable = Executable { FinancialService.CurrencyCode(invalidToCurrency) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun convertCurrency_NegativeAmount_ThrowsException() {
        // given
        val negativeAmount = -100.0

        // when & then
        val executable = Executable { FinancialService.CurrencyAmount(negativeAmount) }
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_USDtoEUR() {
        // given
        val amount = FinancialService.CurrencyAmount(100.0)
        val fromCurrency = FinancialService.CurrencyCode("USD")
        val toCurrency = FinancialService.CurrencyCode("EUR")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        assertEquals(93.0, result.amount)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_USDtoGBP() {
        // given
        val amount = FinancialService.CurrencyAmount(100.0)
        val fromCurrency = FinancialService.CurrencyCode("USD")
        val toCurrency = FinancialService.CurrencyCode("GBP")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        assertEquals(82.0, result.amount)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_UnsupportedPair() {
        // given
        val amount = FinancialService.CurrencyAmount(100.0)
        val fromCurrency = FinancialService.CurrencyCode("EUR")
        val toCurrency = FinancialService.CurrencyCode("JPY")

        // when
        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        // then
        assertEquals(100.0, result.amount) // Expecting a 1:1 conversion rate for unsupported pairs
    }

    // Tests for CurrencyAmount
    @Test
    fun currencyAmount_ValidAmount_Success() {
        assertDoesNotThrow { FinancialService.CurrencyAmount(100.0) }
    }

    @Test
    fun currencyAmount_NegativeAmount_ThrowsException() {
        assertThrows<IllegalArgumentException> { FinancialService.CurrencyAmount(-100.0) }
    }

    @Test
    fun currencyAmount_ZeroAmount_Success() {
        assertDoesNotThrow { FinancialService.CurrencyAmount(0.0) }
    }

    // Tests for CurrencyCode
    @Test
    fun currencyCode_ValidCode_Success() {
        assertDoesNotThrow { FinancialService.CurrencyCode("USD") }
    }

    @Test
    fun currencyCode_InvalidCode_ThrowsException() {
        assertThrows<IllegalArgumentException> { FinancialService.CurrencyCode("usd") } // not uppercase
        assertThrows<IllegalArgumentException> { FinancialService.CurrencyCode("EU") }  // not 3 letters
        assertThrows<IllegalArgumentException> { FinancialService.CurrencyCode("EURO") } // more than 3 letters
    }

    // Tests for AccountNumber
    @Test
    fun accountNumber_ValidNumber_Success() {
        assertDoesNotThrow { FinancialService.AccountNumber("1234567890") }
    }

    @Test
    fun accountNumber_InvalidNumberFormat_ThrowsException() {
        assertThrows<IllegalArgumentException> { FinancialService.AccountNumber("123456789") }  // less than 10 digits
        assertThrows<IllegalArgumentException> { FinancialService.AccountNumber("12345678901") } // more than 10 digits
        assertThrows<IllegalArgumentException> { FinancialService.AccountNumber("12345abcde") }  // contains letters
    }

    // Tests for TransactionId
    @Test
    fun transactionId_ValidId_Success() {
        assertDoesNotThrow { FinancialService.TransactionId("txn123") }
    }

    @Test
    fun transactionId_EmptyId_ThrowsException() {
        assertThrows<IllegalArgumentException> { FinancialService.TransactionId("") }
    }
}
