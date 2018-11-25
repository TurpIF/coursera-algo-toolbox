package fr.pturpin.coursera.fibonacci

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class FibonacciTest {

    @Test
    fun get_GivenBigNumber_ReturnsFibonacci() {
        val fibonacciNumber = Fibonacci(45)

        assert(fibonacciNumber.get()).isEqualTo(1134903170L)
    }

    @Test
    fun getLastDigit_GivenBigNumber_ReturnsDigit() {
        val fibonacciNumber = Fibonacci(45)

        assert(fibonacciNumber.getLastDigit()).isEqualTo(0)
    }

    @Test
    fun getLastDigit_GivenBigNumber_ReturnsDigit2() {
        val fibonacciNumber = Fibonacci(299)

        assert(fibonacciNumber.getLastDigit()).isEqualTo(1)
    }

    @Test
    fun getLastDigit_GivenBigNumber_ReturnsDigit3() {
        val fibonacciNumber = Fibonacci(331)

        assert(fibonacciNumber.getLastDigit()).isEqualTo(9)
    }

    @Test
    fun getLastDigit_GivenBigNumber_ReturnsDigit4() {
        val fibonacciNumber = Fibonacci(327305)

        assert(fibonacciNumber.getLastDigit()).isEqualTo(5)
    }

    @Test
    fun getLastDigit_GivenBigNumber_ReturnsDigit5() {
        val fibonacciNumber = Fibonacci(10_000_000)

        assert(fibonacciNumber.getLastDigit()).isEqualTo(5)
    }

    @Test
    fun getLastDigit_GivenBigNumber_ReturnsDigit6() {
        val fibonacciNumber = Fibonacci(12)

        assert(fibonacciNumber.getLastDigit()).isEqualTo(4)
    }

    @Test
    fun getModulo_GivenBigNumber_ReturnsModulo() {
        val fibonacciNumber = Fibonacci(1_000_000_000_000_000_000L)

        assert(fibonacciNumber.getModulo(1000)).isEqualTo(875)
    }

    @Test
    fun getLastDigitOfSumFromZero_GivenSmallNumber_ReturnsDigit() {
        val fibonacciNumber = Fibonacci(3)

        assert(fibonacciNumber.getLastDigitOfSumFromZero()).isEqualTo(4)
    }

    @Test
    fun getLastDigitOfSumFromZero_GivenBigNumber_ReturnsDigit() {
        val fibonacciNumber = Fibonacci(100)

        assert(fibonacciNumber.getLastDigitOfSumFromZero()).isEqualTo(5)
    }

    @Test
    fun getLastDigitOfSumFrom_GivenNumber_ReturnsDigit() {
        val fibonacciNumber = Fibonacci(7)

        assert(fibonacciNumber.getLastDigitOfSumFrom(3)).isEqualTo(1)
    }

    @Test
    fun getLastDigitOfSumFrom_GivenNumber_ReturnsDigit2() {
        val fibonacciNumber = Fibonacci(10)

        assert(fibonacciNumber.getLastDigitOfSumFrom(10)).isEqualTo(5)
    }

    @Test
    fun getLastDigitOfSumFrom_GivenNumber_ReturnsDigit3() {
        val fibonacciNumber = Fibonacci(200)

        assert(fibonacciNumber.getLastDigitOfSumFrom(10)).isEqualTo(2)
    }

    @Test
    fun getLastDigitOfSumFrom_GivenNumber_ReturnsDigit4() {
        val fibonacciNumber = Fibonacci(1_000_000_000_000_000_000L)

        assert(fibonacciNumber.getLastDigitOfSumFrom(10)).isEqualTo(7)
    }

    @Test
    fun getLastDigitOfSumOfSquares_GivenNumber_ReturnDigit() {
        val fibonacciNumber = Fibonacci(7)

        assert(fibonacciNumber.getLastDigitOfSumOfSquares()).isEqualTo(3)
    }

    @Test
    fun getLastDigitOfSumOfSquares_GivenNumber_ReturnDigit2() {
        val fibonacciNumber = Fibonacci(73)

        assert(fibonacciNumber.getLastDigitOfSumOfSquares()).isEqualTo(1)
    }

    @Test
    fun getLastDigitOfSumOfSquares_GivenNumber_ReturnDigit3() {
        val fibonacciNumber = Fibonacci(1234567890)

        assert(fibonacciNumber.getLastDigitOfSumOfSquares()).isEqualTo(0)
    }

    @Test
    fun getLastDigitOfSumOfSquares_GivenNumber_ReturnDigit4() {
        val fibonacciNumber = Fibonacci(1_000_000_000_000_000_000L)

        assert(fibonacciNumber.getLastDigitOfSumOfSquares()).isEqualTo(5)
    }

}
