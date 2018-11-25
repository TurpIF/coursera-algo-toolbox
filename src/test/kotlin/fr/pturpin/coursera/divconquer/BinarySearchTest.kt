package fr.pturpin.coursera.divconquer

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class BinarySearchTest {

    @Test
    fun indexOf_GivenSample_ReturnsExpected() {
        val binarySearch = BinarySearch(listOf(1, 5, 8, 12, 13))

        assert(binarySearch.indexOf(8)).isEqualTo(2)
        assert(binarySearch.indexOf(1)).isEqualTo(0)
        assert(binarySearch.indexOf(23)).isNull()
        assert(binarySearch.indexOf(1)).isEqualTo(0)
        assert(binarySearch.indexOf(11)).isNull()
    }

    @Test
    fun indexOf_GivenGenerated_ReturnsExpected() {
        val random = Random(123)

        val size = random.nextInt(1, 10000)

        val elements = mutableListOf<Int>()
        for (i in 0 until size) {
            val newElement = random.nextInt(1, 1_000_000_000)
            elements.add(newElement)
        }
        elements.sort()

        val fastAccessElements = mutableSetOf<Int>()
        fastAccessElements.addAll(elements)

        val binarySearch = BinarySearch(elements)

        elements.forEachIndexed { index, element ->
            val indexOf = binarySearch.indexOf(element)
            assert(indexOf).isEqualTo(index)
        }

        for (i in 0 until size) {
            val checkedElement = random.nextInt(1, 1_000_000_000)
            val isExpectedNonNull = fastAccessElements.contains(checkedElement)

            if (isExpectedNonNull) {
                assert(binarySearch.indexOf(checkedElement)).isNotNull()
            } else {
                assert(binarySearch.indexOf(checkedElement)).isNull()
            }
        }
    }

}
