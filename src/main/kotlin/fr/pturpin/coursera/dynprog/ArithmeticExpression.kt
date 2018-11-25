package fr.pturpin.coursera.dynprog

class ArithmeticExpression(private val strExpression: String) {

    private val cache = ArrayList<MutableList<MinMaxExpression?>>(strExpression.length)

    fun getMaximumValue(): Long {
        clearCache()
        return computeCachedMaximumValue(0, strExpression.length).maxExpression
    }

    private fun clearCache() {
        cache.clear()
        for (i in 0..strExpression.length) {
            val elements = ArrayList<MinMaxExpression?>(strExpression.length)
            for (j in 0..strExpression.length) {
                elements.add(null)
            }
            cache.add(elements)
        }
    }

    private fun computeCachedMaximumValue(indexFrom: Int, indexTo: Int): MinMaxExpression {
        cache[indexFrom][indexTo]?.let { return it }
        val result = computeMaximumValue(indexFrom, indexTo)
        cache[indexFrom][indexTo] = result
        return result
    }

    private fun computeMaximumValue(indexFrom: Int, indexTo: Int): MinMaxExpression {
        if (indexFrom == indexTo - 1) {
            val strNumber = strExpression[indexFrom]
            val value = strNumber.toLong() - '0'.toLong()
            return MinMaxExpression(value, value)
        }

        var minimum = Long.MAX_VALUE
        var maximum = Long.MIN_VALUE

        getSplitExpressions(indexFrom, indexTo)
            .flatMap { computeCandidateValues(it) }
            .forEach { candidate ->
                if (candidate >= maximum) {
                    maximum = candidate
                }
                if (candidate <= minimum) {
                    minimum = candidate
                }
            }

        return MinMaxExpression(minimum, maximum)
    }

    private fun computeCandidateValues(splitExpression: SplitExpression): Sequence<Long> {
        val leftMinMax = computeCachedMaximumValue(splitExpression.leftFrom, splitExpression.leftTo)
        val rightMinMax = computeCachedMaximumValue(splitExpression.rightFrom, splitExpression.rightTo)

        return sequenceOf(
            evaluate(splitExpression.operator, leftMinMax.minExpression, rightMinMax.minExpression),
            evaluate(splitExpression.operator, leftMinMax.maxExpression, rightMinMax.minExpression),
            evaluate(splitExpression.operator, leftMinMax.minExpression, rightMinMax.maxExpression),
            evaluate(splitExpression.operator, leftMinMax.maxExpression, rightMinMax.maxExpression))
    }

    private fun evaluate(operator: Char, left: Long, right: Long): Long {
        when (operator) {
            '+' -> return left + right
            '-' -> return left - right
            '*' -> return left * right
        }
        throw UnsupportedOperationException()
    }

    private fun getSplitExpressions(indexFrom: Int, indexTo: Int): Sequence<SplitExpression> {
        return (indexFrom + 1 until indexTo).step(2)
            .asSequence()
            .map {
                SplitExpression(
                    indexFrom,
                    it,
                    it + 1,
                    indexTo,
                    strExpression[it]
                )
            }
    }

    private data class SplitExpression(
        val leftFrom: Int,
        val leftTo: Int,
        val rightFrom: Int,
        val rightTo: Int,
        val operator: Char)

    private data class MinMaxExpression(
        val minExpression: Long,
        val maxExpression: Long)

}

fun main(args: Array<String>) {
    val expression = readLine()!!
    val arithmeticExpression = ArithmeticExpression(expression)
    val maximumValue = arithmeticExpression.getMaximumValue()
    print(maximumValue)
}
