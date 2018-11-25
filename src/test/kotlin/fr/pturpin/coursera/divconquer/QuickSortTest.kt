package fr.pturpin.coursera.divconquer
import assertk.assert
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class QuickSortTest {

    @Test
    fun sortInPlace_GivenSample_ReturnsExpected() {
        val quickSort = QuickSort(intArrayOf(2, 3, 9, 2, 2))

        val sorted = quickSort.sortInPlace()

        assert(sorted.asList()).containsExactly(2, 2, 2, 3, 9)
    }

    @Test
    fun sortInPlace_GivenSample_ReturnsExpected2() {
        val quickSort = QuickSort(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))

        val sorted = quickSort.sortInPlace()

        assert(sorted.asList()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    @Test
    fun sortInPlace_GivenGenerated_ReturnsExpected() {
        val random = Random(42)

        val size = random.nextInt(1, 100000)
        val elements = IntArray(size)
        for (i in 0 until size) {
            elements[i] = random.nextInt(1, 1_000_000_000)
        }

        val expected = elements.toMutableList()
        expected.sort()

        val quickSort = QuickSort(elements)

        val sorted = quickSort.sortInPlace()

        assert(sorted.asList()).isEqualTo(expected)
    }

}
