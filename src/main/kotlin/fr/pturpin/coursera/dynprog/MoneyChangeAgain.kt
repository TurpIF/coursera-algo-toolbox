package fr.pturpin.coursera.dynprog

class MoneyChangeAgain(private val moneyValue: Int) {

    private val availableCoinValues = setOf(1, 3, 4)
    private val cache = mutableMapOf<Int, Int>()

    fun getMinimumNumberOfCoins(): Int {
        cache.clear()
        return getCachedMinimumNumberOfCoins(moneyValue)
    }

    private fun getCachedMinimumNumberOfCoins(remainingValue: Int): Int {
        cache[remainingValue]?.let { return it }
        val computedResult = computeMinimumNumberOfCoins(remainingValue)
        cache[remainingValue] = computedResult
        return computedResult
    }

    private fun computeMinimumNumberOfCoins(remainingValue: Int): Int {
        if (remainingValue == 0) {
            return 0
        }

        val availableCoins = getAvailableCoinValuesFor(remainingValue)
        assert(availableCoins.toList().isNotEmpty())

        return availableCoins
            .map { 1 + getCachedMinimumNumberOfCoins(remainingValue - it) }
            .min()!!
    }

    private fun getAvailableCoinValuesFor(remainingValue: Int): Iterable<Int> {
        return availableCoinValues.filter { it <= remainingValue }
    }

}

fun main(args: Array<String>) {
    val moneyValue = readLine()!!.toInt()

    val moneyChange = MoneyChangeAgain(moneyValue)
    val minimumNumberOfCoins = moneyChange.getMinimumNumberOfCoins()

    print(minimumNumberOfCoins)
}
