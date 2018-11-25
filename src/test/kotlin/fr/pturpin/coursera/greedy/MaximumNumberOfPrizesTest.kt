package fr.pturpin.coursera.greedy
import assertk.assert
import assertk.assertions.containsExactly
import assertk.assertions.hasSize
import org.junit.jupiter.api.Test

internal class MaximumNumberOfPrizesTest {

    @Test
    fun getDistributedCandies_GivenSample_ReturnsExpected() {
        val maximumNumberOfPrizes = MaximumNumberOfPrizes(6)

        val distributedCandies = maximumNumberOfPrizes.getDistributedCandies()

        assert(distributedCandies).containsExactly(1, 2, 3)
    }

    @Test
    fun getDistributedCandies_GivenSample_ReturnsExpected2() {
        val maximumNumberOfPrizes = MaximumNumberOfPrizes(8)

        val distributedCandies = maximumNumberOfPrizes.getDistributedCandies()

        assert(distributedCandies).containsExactly(1, 2, 5)
    }

    @Test
    fun getDistributedCandies_GivenBigInput_ReturnsExpected() {
        val maximumNumberOfPrizes = MaximumNumberOfPrizes(1_000_000_000)

        val distributedCandies = maximumNumberOfPrizes.getDistributedCandies()

        assert(distributedCandies).hasSize(44720)
    }

}
