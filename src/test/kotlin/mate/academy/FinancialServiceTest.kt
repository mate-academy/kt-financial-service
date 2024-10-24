package mate.academy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FinancialServiceTest {
    private val financialService = FinancialService()

    @Test
    fun transferFunds_ValidInput_SuccessfulTransfer() {
        val source = AccountNumber("1234567890")
        val destination = AccountNumber("0987654321")
        val amount = CurrencyAmount(100.0)
        val currencyCode = CurrencyCode("USD")
        val transactionId = TransactionId("txn123")

        val result = financialService.transferFunds(source, destination, amount, currencyCode, transactionId)

        assertEquals("Transferred 100.0 USD from 1234567890 to 0987654321. Transaction ID: txn123", result)
    }

    @Test
    fun transferFunds_InvalidSourceAccount_ThrowsException() {
        val invalidSource = "12345"
        assertThrows(IllegalArgumentException::class.java) {
            AccountNumber(invalidSource)
        }
    }

    @Test
    fun transferFunds_InvalidDestinationAccount_ThrowsException() {
        val invalidDestination = "12345"
        assertThrows(IllegalArgumentException::class.java) {
            AccountNumber(invalidDestination)
        }
    }

    @Test
    fun transferFunds_NegativeTransferAmount_ThrowsException() {
        val negativeAmount = -100.0
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyAmount(negativeAmount)
        }
    }

    @Test
    fun transferFunds_InvalidCurrencyCode_ThrowsException() {
        val invalidCurrencyCode = "US"
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyCode(invalidCurrencyCode)
        }
    }

    @Test
    fun transferFunds_InvalidTransactionId_ThrowsException() {
        val emptyTransactionId = ""
        assertThrows(IllegalArgumentException::class.java) {
            TransactionId(emptyTransactionId)
        }
    }

    @Test
    fun transferFunds_SameSourceAndDestination_ExpectedBehavior() {
        val sourceAndDestination = AccountNumber("1234567890")
        val amount = CurrencyAmount(100.0)
        val currencyCode = CurrencyCode("USD")
        val transactionId = TransactionId("txn123")

        val result = financialService.transferFunds(
            sourceAndDestination,
            sourceAndDestination,
            amount,
            currencyCode,
            transactionId
        )

        assertEquals("Transferred 100.0 USD from 1234567890 to 1234567890. Transaction ID: txn123", result)
    }

    @Test
    fun convertCurrency_ValidInput_SuccessfulConversion() {
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("USD")
        val toCurrency = CurrencyCode("EUR")

        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        assertEquals(93.0, result.value)
    }

    @Test
    fun convertCurrency_InvalidFromCurrencyCode_ThrowsException() {
        val invalidFromCurrency = "US"
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyCode(invalidFromCurrency)
        }
    }

    @Test
    fun convertCurrency_InvalidToCurrencyCode_ThrowsException() {
        val invalidToCurrency = "EU"
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyCode(invalidToCurrency)
        }
    }

    @Test
    fun convertCurrency_NegativeAmount_ThrowsException() {
        val negativeAmount = -100.0
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyAmount(negativeAmount)
        }
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_USDtoEUR() {
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("USD")
        val toCurrency = CurrencyCode("EUR")

        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        assertEquals(93.0, result.value)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_USDtoGBP() {
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("USD")
        val toCurrency = CurrencyCode("GBP")

        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        assertEquals(82.0, result.value)
    }

    @Test
    fun convertCurrency_ExpectedConversionRate_UnsupportedPair() {
        val amount = CurrencyAmount(100.0)
        val fromCurrency = CurrencyCode("EUR")
        val toCurrency = CurrencyCode("JPY")

        val result = financialService.convertCurrency(amount, fromCurrency, toCurrency)

        assertEquals(100.0, result.value)
    }

    @Test
    fun currencyAmount_ValidAmount_Success() {
        assertDoesNotThrow {
            CurrencyAmount(100.0)
        }
    }

    @Test
    fun currencyAmount_NegativeAmount_ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyAmount(-100.0)
        }
    }

    @Test
    fun currencyAmount_ZeroAmount_Success() {
        assertDoesNotThrow {
            CurrencyAmount(0.0)
        }
    }

    @Test
    fun currencyCode_ValidCode_Success() {
        assertDoesNotThrow {
            CurrencyCode("USD")
        }
    }

    @Test
    fun currencyCode_InvalidCode_ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyCode("usd")
        }
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyCode("EU")
        }
        assertThrows(IllegalArgumentException::class.java) {
            CurrencyCode("EURO")
        }
    }

    @Test
    fun accountNumber_ValidNumber_Success() {
        assertDoesNotThrow {
            AccountNumber("1234567890")
        }
    }

    @Test
    fun accountNumber_InvalidNumberFormat_ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            AccountNumber("123456789")
        }
        assertThrows(IllegalArgumentException::class.java) {
            AccountNumber("12345678901")
        }
        assertThrows(IllegalArgumentException::class.java) {
            AccountNumber("12345abcde")
        }
    }

    @Test
    fun transactionId_ValidId_Success() {
        assertDoesNotThrow {
            TransactionId("txn123")
        }
    }

    @Test
    fun transactionId_EmptyId_ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            TransactionId("")
        }
    }
}
