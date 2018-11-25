package fr.pturpin.coursera.greedy

import java.util.*

class MaximumAdvertisementRevenue {

    private val profitsPerClick = PriorityQueue<Int>()
    private val averageNumbersOfClicksPerDay = PriorityQueue<Int>()

    fun addProfitPerClick(profit: Int) {
        profitsPerClick.add(profit)
    }

    fun addAverageNumberOfClicksPerDay(numberOfClicks: Int) {
        averageNumbersOfClicksPerDay.add(numberOfClicks)
    }

    fun getMaximumSumOfProducts(): Long {
        var sum = 0L
        while (profitsPerClick.isNotEmpty() && averageNumbersOfClicksPerDay.isNotEmpty()) {
            val profit = profitsPerClick.remove()
            val numberOfClicks = averageNumbersOfClicksPerDay.remove()
            sum += profit.toLong() * numberOfClicks
        }
        return sum
    }

}

fun main(args: Array<String>) {
    val maximumAdvertisementRevenue = MaximumAdvertisementRevenue()

    readLine()!! // Ignored

    readLine()!!.split(" ")
        .map { it.toInt() }
        .forEach { maximumAdvertisementRevenue.addProfitPerClick(it) }

    readLine()!!.split(" ")
        .map { it.toInt() }
        .forEach { maximumAdvertisementRevenue.addAverageNumberOfClicksPerDay(it) }

    val maximumSumOfProducts = maximumAdvertisementRevenue.getMaximumSumOfProducts()

    print(maximumSumOfProducts)
}
