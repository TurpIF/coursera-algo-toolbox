package fr.pturpin.coursera.base

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MaximumPairwiseProductTest {

    @Test
    fun addCandidate_givenNegative_ThrowsException() {
        val maximumPairwiseProduct = MaximumPairwiseProduct()

        assertThrows<IllegalStateException> {
            maximumPairwiseProduct.addCandidate(-1)
        }
    }

    @Test
    fun getMaxPairwiseProduct_givenZeroElements_ThrowsException() {
        val maximumPairwiseProduct = MaximumPairwiseProduct()

        assertThrows<IllegalStateException> {
            maximumPairwiseProduct.getMaxPairwiseProduct()
        }
    }

    @Test
    fun getMaxPairwiseProduct_givenOneElements_ThrowsException() {
        val maximumPairwiseProduct = MaximumPairwiseProduct()
        maximumPairwiseProduct.addCandidate(2)

        assertThrows<IllegalStateException> {
            maximumPairwiseProduct.getMaxPairwiseProduct()
        }
    }

    @Test
    fun getMaxPairwiseProduct_givenTwoElements_ReturnsTheirProduct() {
        val maximumPairwiseProduct = MaximumPairwiseProduct()
        maximumPairwiseProduct.addCandidate(2)
        maximumPairwiseProduct.addCandidate(3)

        assert(maximumPairwiseProduct.getMaxPairwiseProduct()).isEqualTo(6L)
    }

    @Test
    fun getMaxPairwiseProduct_givenManyElements_ReturnsMaxProduct() {
        val maximumPairwiseProduct = MaximumPairwiseProduct()
        maximumPairwiseProduct.addCandidate(1)
        maximumPairwiseProduct.addCandidate(2)
        maximumPairwiseProduct.addCandidate(0)
        maximumPairwiseProduct.addCandidate(3)

        assert(maximumPairwiseProduct.getMaxPairwiseProduct()).isEqualTo(6L)
    }

    @Test
    fun getMaxPairwiseProduct_givenBigElements_ReturnsMaxProductWithoutOverflow() {
        val maximumPairwiseProduct = MaximumPairwiseProduct()
        maximumPairwiseProduct.addCandidate(1)
        maximumPairwiseProduct.addCandidate(Integer.MAX_VALUE)
        maximumPairwiseProduct.addCandidate(Integer.MAX_VALUE - 1)
        maximumPairwiseProduct.addCandidate(3)

        val expected = Integer.MAX_VALUE.toLong() * (Integer.MAX_VALUE - 1)
        assert(maximumPairwiseProduct.getMaxPairwiseProduct()).isEqualTo(expected)
    }

}
