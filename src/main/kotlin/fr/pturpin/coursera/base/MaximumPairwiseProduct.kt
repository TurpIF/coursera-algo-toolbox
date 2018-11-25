package fr.pturpin.coursera.base

class MaximumPairwiseProduct {

    private var maximum: Int? = null
    private var secondMaximum: Int? = null

    fun addCandidate(candidate: Int) {
        if (candidate < 0) {
            throw IllegalStateException()
        }

        if (maximum == null) {
            maximum = candidate
        } else if (secondMaximum == null || candidate > secondMaximum!!) {
            secondMaximum = candidate

            val currentMax = maximum!!
            if (candidate > currentMax) {
                maximum = candidate
                secondMaximum = currentMax
            }
        }
    }

    fun getMaxPairwiseProduct(): Long {
        if (maximum == null || secondMaximum == null) {
            throw IllegalStateException()
        }
        return maximum!!.toLong() * secondMaximum!!
    }

}

fun main(args: Array<String>) {
    val maximumPairwiseProduct = MaximumPairwiseProduct()

    readLine()!! // Ignore first line
    readLine()!!
        .split(" ")
        .map { it.toInt() }
        .forEach { maximumPairwiseProduct.addCandidate(it) }

    val maxPairwiseProduct = maximumPairwiseProduct.getMaxPairwiseProduct()

    print(maxPairwiseProduct)
}
