package fr.pturpin.coursera.greedy

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isStrictlyBetween
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class MaximumValueOfTheLootTest {

    @Test
    fun formatOutput_GivenInteger_ReturnsWithTrailingZeros() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(42)

        val output = maximumValueOfTheLoot.formatOutput(1337.0)

        assert(output).isEqualTo("1337.0000")
    }

    @Test
    fun formatOutput_GivenDoubleWithLessSupportedPrecision_ReturnsWithTrailingZeros() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(42)

        val output = maximumValueOfTheLoot.formatOutput(13.37)

        assert(output).isEqualTo("13.3700")
    }

    @Test
    fun formatOutput_GivenDoubleWithMoreSupportedPrecision_ReturnsRoundedToNearestDouble() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(42)

        val output = maximumValueOfTheLoot.formatOutput(0.133742)

        assert(output).isEqualTo("0.1337")
    }

    @Test
    fun formatOutput_GivenDoubleWithMoreSupportedPrecision_ReturnsRoundedToNearestDouble2() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(42)

        val output = maximumValueOfTheLoot.formatOutput(0.13376)

        assert(output).isEqualTo("0.1338")
    }

    @Test
    fun formatOutput_GivenDoubleWithMoreSupportedPrecision_ReturnsRoundedToNearestDouble3() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(42)

        val output = maximumValueOfTheLoot.formatOutput(0.13375)

        assert(output).isEqualTo("0.1338")
    }

    @Test
    fun getMaximalValueOfFractionsOfItemsFittingIn_GivenSample_ReturnsExpected() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(50)

        maximumValueOfTheLoot.addPotentialItem(60, 20)
        maximumValueOfTheLoot.addPotentialItem(100, 50)
        maximumValueOfTheLoot.addPotentialItem(120, 30)

        val maximalValue = maximumValueOfTheLoot.getMaximalValueOfFractionsOfItemsFittingIn()

        assert(maximalValue).isEqualTo(180.0)
    }

    @Test
    fun getMaximalValueOfFractionsOfItemsFittingIn_GivenSample_ReturnsExpected2() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(10)

        maximumValueOfTheLoot.addPotentialItem(500, 30)

        val maximalValue = maximumValueOfTheLoot.getMaximalValueOfFractionsOfItemsFittingIn()

        assert(maximalValue).isStrictlyBetween(166.6666, 166.6667)
    }

    @Test
    fun getMaximalValueOfFractionsOfItemsFittingIn_GivenSample_ReturnsExpected3() {
        val maximumValueOfTheLoot = MaximumValueOfTheLoot(10000)

        maximumValueOfTheLoot.addPotentialItem(500, 30)

        val maximalValue = maximumValueOfTheLoot.getMaximalValueOfFractionsOfItemsFittingIn()

        assert(maximalValue).isEqualTo(500.0)
    }

    @Test
    fun getMaximalValueOfFractionsOfItemsFittingIn_GivenGeneratedSample_DoesNotThrow() {
        val random = Random(1234)
        val nbTries = 10000

        for (j in 0 until nbTries) {
            val knapsackCapacity = random.nextInt(0, 2 * 1_000_000)
            val maximumValueOfTheLoot = MaximumValueOfTheLoot(knapsackCapacity)

            val numberOfItems = random.nextInt(1, 1000)
            for (i in 0 until numberOfItems) {
                val itemValue = random.nextInt(0, 2 * 1_000_000)
                val itemWeight = random.nextInt(1, 2 * 1_000_000)
                maximumValueOfTheLoot.addPotentialItem(itemValue, itemWeight)
            }

            maximumValueOfTheLoot.getMaximalValueOfFractionsOfItemsFittingIn()
        }
    }

}
