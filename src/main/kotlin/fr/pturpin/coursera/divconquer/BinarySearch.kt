package fr.pturpin.coursera.divconquer

import java.util.stream.Collectors

class BinarySearch(private val sortedSequence: List<Int>) {

    fun indexOf(value: Int): Int? {
        var startIndex = 0
        var endIndex = sortedSequence.size - 1

        while (startIndex < endIndex) {
            val midIndex = (startIndex + endIndex) / 2
            val midValue = sortedSequence[midIndex]
            val comparison = value.compareTo(midValue)
            when {
                comparison == 0 -> return midIndex
                comparison > 0 -> startIndex = midIndex + 1
                else -> endIndex = midIndex - 1
            }
        }

        if (sortedSequence[startIndex] == value) {
            return startIndex
        }
        return null
    }

}

fun main(args: Array<String>) {
    val elements = readLine()!!.split(" ").map { it.toInt() }.drop(1)

    val binarySearch = BinarySearch(elements)

    val output = readLine()!!.split(" ").stream()
        .skip(1)
        .map { it.toInt() }
        .map { binarySearch.indexOf(it) ?: -1 }
        .map { it.toString() }
        .collect(Collectors.joining(" "))

    print(output)
}
