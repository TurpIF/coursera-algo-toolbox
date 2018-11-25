package fr.pturpin.coursera.greedy

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class MaximumAdvertisementRevenueTest {

    @Test
    fun getMaximumSumOfProducts_GivenSample_ReturnsExpected() {
        val maximumAdvertisementRevenue = MaximumAdvertisementRevenue()

        maximumAdvertisementRevenue.addProfitPerClick(23)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(39)
        val maximumSumOfProducts = maximumAdvertisementRevenue.getMaximumSumOfProducts()

        assert(maximumSumOfProducts).isEqualTo(897L)
    }

    @Test
    fun getMaximumSumOfProducts_GivenSample_ReturnsExpected2() {
        val maximumAdvertisementRevenue = MaximumAdvertisementRevenue()

        maximumAdvertisementRevenue.addProfitPerClick(1)
        maximumAdvertisementRevenue.addProfitPerClick(3)
        maximumAdvertisementRevenue.addProfitPerClick(-5)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(-2)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(4)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(1)
        val maximumSumOfProducts = maximumAdvertisementRevenue.getMaximumSumOfProducts()

        assert(maximumSumOfProducts).isEqualTo(23L)
    }

    @Test
    fun getMaximumSumOfProducts_GivenSample_ReturnsExpected3() {
        val maximumAdvertisementRevenue = MaximumAdvertisementRevenue()

        maximumAdvertisementRevenue.addProfitPerClick(1)
        maximumAdvertisementRevenue.addProfitPerClick(3)
        maximumAdvertisementRevenue.addProfitPerClick(5)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(2)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(4)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(1)
        val maximumSumOfProducts = maximumAdvertisementRevenue.getMaximumSumOfProducts()

        assert(maximumSumOfProducts).isEqualTo(27L)
    }

    @Test
    fun getMaximumSumOfProducts_GivenBigInput_ReturnsExpected() {
        val maximumAdvertisementRevenue = MaximumAdvertisementRevenue()

        maximumAdvertisementRevenue.addProfitPerClick(Integer.MAX_VALUE)
        maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(2)
        val maximumSumOfProducts = maximumAdvertisementRevenue.getMaximumSumOfProducts()

        assert(maximumSumOfProducts).isEqualTo(2L * Integer.MAX_VALUE)
    }

}
