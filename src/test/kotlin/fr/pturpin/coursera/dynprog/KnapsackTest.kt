package fr.pturpin.coursera.dynprog

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class KnapsackTest {

    @Test
    fun getMaximumAmountOfGold_GivenEmptyBar_ReturnsZero() {
        val knapsack = Knapsack(42)
        val maximumAmountOfGold = knapsack.getMaximumAmountOfGold()

        assert(maximumAmountOfGold).isEqualTo(0)
    }

    @Test
    fun getMaximumAmountOfGold_GivenSample_ReturnsExpected() {
        val knapsack = Knapsack(10)
        knapsack.addGoldBar(1)
        knapsack.addGoldBar(4)
        knapsack.addGoldBar(8)
        val maximumAmountOfGold = knapsack.getMaximumAmountOfGold()

        assert(maximumAmountOfGold).isEqualTo(9)
    }

    @Test
    fun getMaximumAmountOfGold_GivenBigSample_ReturnsExpected() {
        val knapsack = Knapsack(10_000)
        val goldBars = (1..300).toList()
        goldBars.forEach { knapsack.addGoldBar(it) }
        val maximumAmountOfGold = knapsack.getMaximumAmountOfGold()

        assert(maximumAmountOfGold).isEqualTo(10_000)
    }

    @Test
    fun getMaximumAmountOfGold_GivenBigSample_ReturnsExpected2() {
        val knapsack = Knapsack(10_000)
        val goldBars = (1..300).map { 30 }.toList()
        goldBars.forEach { knapsack.addGoldBar(it) }
        val maximumAmountOfGold = knapsack.getMaximumAmountOfGold()

        val expected = goldBars.sum()

        assert(maximumAmountOfGold).isEqualTo(expected)
    }

}
