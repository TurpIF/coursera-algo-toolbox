package fr.pturpin.coursera.dynprog

class EditDistance(private val string1: String, private val string2: String) {

    private val cache = mutableMapOf<BiIndex, Int>()

    fun getDistance(): Int {
        cache.clear()
        return computeCachedDistance(BiIndex(0, 0))
    }

    private fun computeCachedDistance(biIndex: BiIndex): Int {
        cache[biIndex]?.let { return it }
        val computedResult = computeDistance(biIndex)
        cache[biIndex] = computedResult
        return computedResult
    }

    private fun computeDistance(biIndex: BiIndex): Int {
        val (index1, index2) = biIndex
        if (index1 == string1.length) {
            return string2.length - index2
        } else if (index2 == string2.length) {
            return string1.length - index1
        }

        val hasSameChar = string1[index1] == string2[index2]
        return if (hasSameChar) {
            listOf(
                computeCachedDistance(biIndex.advanceBoth()), // no edition
                1 + computeCachedDistance(biIndex.advance1()), // insertion
                1 + computeCachedDistance(biIndex.advance2()) // deletion
            ).min()!!
        } else {
            listOf(
                1 + computeCachedDistance(biIndex.advanceBoth()), // substitution
                1 + computeCachedDistance(biIndex.advance1()), // insertion
                1 + computeCachedDistance(biIndex.advance2()) // deletion
            ).min()!!
        }
    }

    private data class BiIndex(val index1: Int, val index2: Int) {

        fun advanceBoth(): BiIndex {
            return BiIndex(index1 + 1, index2 + 1)
        }

        fun advance1(): BiIndex {
            return BiIndex(index1 + 1, index2)
        }

        fun advance2(): BiIndex {
            return BiIndex(index1, index2 + 1)
        }

    }

}

fun main(args: Array<String>) {
    val string1 = readLine()!!
    val string2 = readLine()!!

    val editDistance = EditDistance(string1, string2)
    val distance = editDistance.getDistance()

    print(distance)
}
