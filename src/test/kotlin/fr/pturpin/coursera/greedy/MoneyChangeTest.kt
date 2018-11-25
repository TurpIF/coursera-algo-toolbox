package fr.pturpin.coursera.greedy

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class MoneyChangeTest {

    @Test
    fun getMinimumNumberOfCoins_GivenOne_ReturnsOne() {
        val moneyChange = MoneyChange(1)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assert(minimumNumberOfCoins).isEqualTo(1)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenMoneyValue_ReturnsExpected() {
        val moneyChange = MoneyChange(2)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assert(minimumNumberOfCoins).isEqualTo(2)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenMoneyValue_ReturnsExpected2() {
        val moneyChange = MoneyChange(28)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assert(minimumNumberOfCoins).isEqualTo(6)
    }

    @Test
    fun getMinimumNumberOfCoins_GivenBigMoneyValue_ReturnsExpected() {
        val moneyChange = MoneyChange(1000)

        val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

        assert(minimumNumberOfCoins).isEqualTo(100)
    }

}
