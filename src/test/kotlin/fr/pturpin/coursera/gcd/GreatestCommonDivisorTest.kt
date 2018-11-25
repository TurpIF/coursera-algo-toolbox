package fr.pturpin.coursera.gcd

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class GreatestCommonDivisorTest {

    @Test
    fun get_GivenSmallNumbers_ReturnsExpected() {
        val gcd = GreatestCommonDivisor(18, 35)

        assert(gcd.get()).isEqualTo(1L)
    }

    @Test
    fun get_GivenBigNumbers_ReturnsExpected() {
        val gcd = GreatestCommonDivisor(28851538, 1183019)

        assert(gcd.get()).isEqualTo(17657L)
    }

    @Test
    fun getLcm_GivenSmallNumbers_ReturnsExpected() {
        val gcd = GreatestCommonDivisor(6, 8)

        assert(gcd.getLcm()).isEqualTo(24L)
    }

    @Test
    fun getLcm_GivenBigNumbers_ReturnsExpected() {
        val gcd = GreatestCommonDivisor(28851538, 1183019)

        assert(gcd.getLcm()).isEqualTo(1933053046L)
    }

}
