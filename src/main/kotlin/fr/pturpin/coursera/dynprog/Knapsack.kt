package fr.pturpin.coursera.dynprog

import kotlin.math.max

class Knapsack(private val capacity: Int) {

    private val goldBars = mutableListOf<Int>()
    private val cache = ArrayList<IntArray>(capacity)

    fun addGoldBar(weight: Int) {
        goldBars.add(weight)
    }

    fun getMaximumAmountOfGold(): Int {
        clearCache()
        return computeCachedMaximumAmountOfGold(0, capacity)
    }

    private fun clearCache() {
        cache.clear()
        for (i in 0..capacity) {
            cache.add(IntArray(goldBars.size + 1) { -1 })
        }
    }

    private fun computeCachedMaximumAmountOfGold(currentIndex: Int, remainingCapacity: Int): Int {
        cache[remainingCapacity][currentIndex].takeIf { it >= 0 }?.let { return it }
        val result = computeMaximumAmountOfGold(currentIndex, remainingCapacity)
        cache[remainingCapacity][currentIndex] = result
        return result
    }

    private fun computeMaximumAmountOfGold(currentIndex: Int, remainingCapacity: Int): Int {
        if (currentIndex >= goldBars.size || remainingCapacity == 0) {
            return 0
        }

        val goldBar = goldBars[currentIndex]
        val isUsable = goldBar <= remainingCapacity

        val whenUnusedResult = computeCachedMaximumAmountOfGold(currentIndex + 1, remainingCapacity)

        if (isUsable) {
            val whenFittingResult = computeCachedMaximumAmountOfGold(currentIndex + 1, remainingCapacity - goldBar) + goldBar
            return max(whenFittingResult, whenUnusedResult)
        }
        return whenUnusedResult
    }

}

fun main(args: Array<String>) {
    val (capacity, _) = readLine()!!.split(" ").map { it.toInt() }
    val knapsack = Knapsack(capacity)

    readLine()!!.splitToSequence(" ").map { it.toInt() }.forEach { knapsack.addGoldBar(it) }

    val maximumAmountOfGold = knapsack.getMaximumAmountOfGold()
    print(maximumAmountOfGold)
}
