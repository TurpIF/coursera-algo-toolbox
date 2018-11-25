package fr.pturpin.coursera.dynprog

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class EditDistanceTest {

    @Test
    fun getDistance_GivenSample_ReturnsExpected() {
        val editDistance = EditDistance("ab", "ab")

        val distance = editDistance.getDistance()

        assert(distance).isEqualTo(0)
    }

    @Test
    fun getDistance_GivenSample_ReturnsExpected2() {
        val editDistance = EditDistance("short", "ports")

        val distance = editDistance.getDistance()

        assert(distance).isEqualTo(3)
    }

    @Test
    fun getDistance_GivenSample_ReturnsExpected3() {
        val editDistance = EditDistance("editing", "distance")

        val distance = editDistance.getDistance()

        assert(distance).isEqualTo(5)
    }

    @Test
    fun getDistance_GivenBigInput_ReturnsExpected() {
        val editDistance = EditDistance(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
        )

        val distance = editDistance.getDistance()

        assert(distance).isEqualTo(100)
    }

}
