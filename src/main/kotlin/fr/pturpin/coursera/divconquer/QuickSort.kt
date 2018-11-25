package fr.pturpin.coursera.divconquer

import java.util.*

class QuickSort(private val elements: IntArray) {

    private val random = Random(42)

    fun sortInPlace(): IntArray {
        sortInPlace(0, elements.size)
        return elements
    }

    private fun sortInPlace(from: Int, untilExcluded: Int) {
        if (from == untilExcluded) {
            return
        }

        val pivotIndex = getPivotIndex(from, untilExcluded)
        val partition = partitionAround(elements[pivotIndex], from, untilExcluded)
        sortInPlace(partition.lowerFrom, partition.lowerUntil)
        sortInPlace(partition.higherFrom, partition.higherUntil)
    }

    private fun partitionAround(pivotValue: Int, from: Int, untilExcluded: Int): Partition {
        var lowerUntil = from
        var higherFrom = untilExcluded

        var i = from
        while(i < higherFrom) {
            val currentValue = elements[i]
            if (currentValue < pivotValue) {
                swap(lowerUntil, i)
                lowerUntil++
            } else if (currentValue > pivotValue) {
                higherFrom--
                swap(higherFrom, i)
                i--
            }
            i++
        }

        elements.fill(pivotValue, lowerUntil, higherFrom - 1)

        return Partition(from, lowerUntil, higherFrom, untilExcluded)
    }

    private fun swap(i: Int, j: Int) {
        val tmp = elements[i]
        elements[i] = elements[j]
        elements[j] = tmp
    }

    private fun getPivotIndex(from: Int, untilExcluded: Int): Int {
        return random.nextInt(untilExcluded - from) + from
    }

    private data class Partition(val lowerFrom: Int, val lowerUntil: Int, val higherFrom: Int, val higherUntil: Int) {

        init {
            assert(lowerFrom <= lowerUntil)
            assert(lowerUntil < higherFrom)
            assert(higherFrom <= higherUntil)
        }

    }

}

fun main(args: Array<String>) {
    readLine()!!
    val elements = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val quickSort = QuickSort(elements)
    val sorted = quickSort.sortInPlace()

    print(sorted.joinToString(" "))
}
