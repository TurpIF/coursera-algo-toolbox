package fr.pturpin.coursera.dynprog
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class MoneyChangeAgainTest {

    @Test
    fun getMinimumNumberOfCoins_GivenOne_ReturnsOne() {
        val moneyChange = MoneyChangeAgain(1)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assertk.assert(minimumNumberOfCoins).isEqualTo(1)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenMoneyValue_ReturnsExpected() {
        val moneyChange = MoneyChangeAgain(2)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assertk.assert(minimumNumberOfCoins).isEqualTo(2)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenMoneyValue_ReturnsExpected2() {
        val moneyChange = MoneyChangeAgain(28)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assertk.assert(minimumNumberOfCoins).isEqualTo(7)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenBigMoneyValue_ReturnsExpected() {
        val moneyChange = MoneyChangeAgain(1000)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assertk.assert(minimumNumberOfCoins).isEqualTo(250)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenSample_ReturnsExpected() {
        val moneyChange = MoneyChangeAgain(34)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assertk.assert(minimumNumberOfCoins).isEqualTo(9)
    }

}
