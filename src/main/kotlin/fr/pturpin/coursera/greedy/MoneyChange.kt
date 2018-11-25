package fr.pturpin.coursera.greedy

class MoneyChange(private val moneyValue: Int) {

    private val availableCoinValues = sortedSetOf(10, 5, 1).reversed()

    fun getMinimumNumberOfCoins(): Int {
        var numberOfCoins = 0
        var remainingValue = moneyValue
        for (availableCoinValue in availableCoinValues) {
            val nbUsedCoin = remainingValue / availableCoinValue
            remainingValue -= nbUsedCoin * availableCoinValue
            numberOfCoins +=  nbUsedCoin
        }
        return numberOfCoins
    }

}

fun main(args: Array<String>) {
    val m = readLine()!!.toInt()

    val minimumNumberOfCoins = MoneyChange(m).getMinimumNumberOfCoins()

    print(minimumNumberOfCoins)
}
