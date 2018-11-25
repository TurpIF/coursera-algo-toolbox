package fr.pturpin.coursera.greedy

import java.util.*

class MaximumValueOfTheLoot(private val knapsackCapacity: Int) {

    private val formatPrecision = 4
    private var weightOfCandidates = 0
    private val sortedByLowValuationCandidates = PriorityQueue<Item>()

    fun addPotentialItem(itemValue: Int, itemWeight: Int) {
        addNewCandidate(Item(itemValue, itemWeight))

        if (!isLowestCandidateUseful()) {
            removeLowestCandidate()
        }
    }

    private fun isLowestCandidateUseful(): Boolean {
        if (weightOfCandidates <= knapsackCapacity) {
            return true
        }

        val lowestValuableCandidate = sortedByLowValuationCandidates.element()
        return weightOfCandidates - lowestValuableCandidate.weight < knapsackCapacity
    }

    private fun addNewCandidate(newCandidate: Item) {
        sortedByLowValuationCandidates.add(newCandidate)
        weightOfCandidates += newCandidate.weight
    }

    private fun removeLowestCandidate() {
        val lowestCandidate = sortedByLowValuationCandidates.remove()
        weightOfCandidates -= lowestCandidate.weight
    }

    fun getMaximalValueOfFractionsOfItemsFittingIn(): Double {
        if (knapsackCapacity == 0) {
            return 0.0
        }

        val highestValuationsValue = sortedByLowValuationCandidates.stream()
            .skip(1)
            .mapToDouble { it.value.toDouble() }
            .sum()

        val lowestValuableCandidate = sortedByLowValuationCandidates.element()
        val partialValue = if (weightOfCandidates <= knapsackCapacity) {
            lowestValuableCandidate.value.toDouble()
        } else {
            val remainingWeight = knapsackCapacity - (weightOfCandidates - lowestValuableCandidate.weight)
            lowestValuableCandidate.value * remainingWeight.toDouble() / lowestValuableCandidate.weight
        }

        return highestValuationsValue + partialValue
    }

    fun formatOutput(value: Double): String {
        val format = "%." + formatPrecision + "f"
        return format.format(Locale.US, value)
    }

    private data class Item(val value: Int, val weight: Int) : Comparable<Item> {

        private fun getValueByWeight() = value.toDouble() / weight

        override fun compareTo(other: Item): Int {
            return getValueByWeight().compareTo(other.getValueByWeight())
        }

    }

}

fun main(args: Array<String>) {
    val (n, knapsackCapacity) = readLine()!!.split(" ").map { it.toInt() }

    val maximumValueOfTheLoot = MaximumValueOfTheLoot(knapsackCapacity)

    for (i in 0 until n) {
        val (value, weight) = readLine()!!.split(" ").map { it.toInt() }

        maximumValueOfTheLoot.addPotentialItem(value, weight)
    }

    val maximalValue = maximumValueOfTheLoot.getMaximalValueOfFractionsOfItemsFittingIn()

    print(maximumValueOfTheLoot.formatOutput(maximalValue))
}
