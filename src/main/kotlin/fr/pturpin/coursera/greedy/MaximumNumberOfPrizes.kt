package fr.pturpin.coursera.greedy

class MaximumNumberOfPrizes(private val candiesNumber: Int) {

    fun getDistributedCandies() : List<Int> {
        var currentPrize = 1
        var remainingCandies = candiesNumber
        val prizes = mutableListOf<Int>()

        while (remainingCandies >= 2 * currentPrize + 1) {
            prizes.add(currentPrize)
            remainingCandies -= currentPrize
            currentPrize++
        }

        if (remainingCandies > 0) {
            prizes.add(remainingCandies)
        }

        return prizes
    }

}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val distributedCandies = MaximumNumberOfPrizes(n).getDistributedCandies()

    println(distributedCandies.size)
    distributedCandies.subList(0, distributedCandies.size - 1).forEach {
        print(it)
        print(" ")
    }
    print(distributedCandies.last())
}
