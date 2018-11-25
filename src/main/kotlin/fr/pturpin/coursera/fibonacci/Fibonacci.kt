package fr.pturpin.coursera.fibonacci

class Fibonacci(private val n: Long) {

    // Every 60 iterations from 0, the last digits are looping.
    private val digitLoopLength = 60

    private val cache = mutableMapOf<Long, Long>()

    fun get(): Long {
        clearCache()
        return computeFibonacci(n)
    }

    fun getLastDigit() = getModulo(10)

    fun getModulo(modulo: Int): Int {
        clearCache()
        return computeFibonacciModulo(n, modulo)
    }

    fun getLastDigitOfSumFromZero() = getLastDigitOfSumFrom(0)

    fun getLastDigitOfSumFrom(m: Long): Int {
        clearCache()

        val loopStartAfterM = (m / digitLoopLength + 1) * digitLoopLength
        val loopStartBeforeN = (n / digitLoopLength) * digitLoopLength

        val lastDigitFromM = computeLastDigitOfSumFrom(m, loopStartAfterM)
        val lastDigitToN = computeLastDigitOfSumFrom(loopStartBeforeN, n)
        val lastDigitBetween: Int

        val numberOfFullLoops = loopStartBeforeN - loopStartAfterM
        if (numberOfFullLoops > 0) {
            val lastDigitOfFullLoop = computeLastDigitOfSumFrom(0, digitLoopLength.toLong())
            // There is no overflow because number of full loops is at most MAX_VALUE / 60 and lastDigit is at most 9
            lastDigitBetween = ((lastDigitOfFullLoop * numberOfFullLoops) % 10).toInt()
        } else {
            lastDigitBetween = 0
        }

        return (lastDigitFromM + lastDigitBetween + lastDigitToN) % 10
    }

    fun getLastDigitOfSumOfSquares(): Int {
        clearCache()

        // sum(F(k)**2) = F(n + 1) * F(n)

        val lastDigitOfCurrent = computeFibonacciModulo(n, 10)
        val lastDigitOfNext = computeFibonacciModulo(n + 1, 10)
        return (lastDigitOfCurrent * lastDigitOfNext) % 10
    }

    private fun computeLastDigitOfSumFrom(fromIncluded: Long, toIncluded: Long): Int {
        var lastDigitOfSum = 0
        for (i in fromIncluded..toIncluded) {
            val fibonacciDigit = computeFibonacciModulo(i, 10)
            lastDigitOfSum += fibonacciDigit
            lastDigitOfSum %= 10
        }
        return lastDigitOfSum
    }

    private fun clearCache() {
        cache.clear()
        cache[0] = 0
        cache[1] = 1
        cache[2] = 1
    }

    private fun computeFibonacciModulo(n: Long, modulo: Int): Int {
        return computeFibonacci(n) { positiveRem(it, modulo) }.toInt()
    }

    private fun positiveRem(number: Long, modulo: Int): Long {
        val rem = number.rem(modulo)
        return if (rem < 0) {
            rem + modulo
        } else {
            rem
        }
    }

    private fun computeFibonacci(n: Long, applyOnEach: (Long) -> Long = { it }): Long {
        if (n < 0) {
            throw IllegalArgumentException()
        }

        cache[n]?.let { return it }

        // F(n) = F(n / 2 - 1)**2 - (-1)**n * F((n - 1) / 2) ** 2
        val subFibonacci1 = computeFibonacci((n / 2) + 1, applyOnEach)
        val subFibonacci2 = computeFibonacci((n - 1) / 2, applyOnEach)
        val factor = if (n % 2 == 1L) -1 else 1

        val fibonacci = subFibonacci1 * subFibonacci1 - factor * subFibonacci2 * subFibonacci2
        val transformedFibonacci = applyOnEach(fibonacci)
        cache[n] = transformedFibonacci
        return transformedFibonacci
    }

}
