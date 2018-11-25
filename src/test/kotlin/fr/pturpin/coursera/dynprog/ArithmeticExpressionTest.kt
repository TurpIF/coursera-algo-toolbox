package fr.pturpin.coursera.dynprog
import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class ArithmeticExpressionTest {

    @Test
    fun getMaximumValue_GivenSample_ReturnsExpected() {
        val arithmeticExpression = ArithmeticExpression("1+5")
        val maximumValue = arithmeticExpression.getMaximumValue()

        assert(maximumValue).isEqualTo(6L)
    }

    @Test
    fun getMaximumValue_GivenSample_ReturnsExpected2() {
        val arithmeticExpression = ArithmeticExpression("5-8+7*4-8+9")
        val maximumValue = arithmeticExpression.getMaximumValue()

        assert(maximumValue).isEqualTo(200L)
    }

    @Test
    fun getMaximumValue_GivenBiggestExpression_ReturnsExpected() {
        val sb = StringBuilder()
        sb.append('9')
        for (i in 0 until 14) {
            sb.append("*9")
        }

        val arithmeticExpression = ArithmeticExpression(sb.toString())
        val maximumValue = arithmeticExpression.getMaximumValue()

        val expected = Math.pow(9.0, 15.0).toLong()

        assert(maximumValue).isEqualTo(expected)
    }

}
