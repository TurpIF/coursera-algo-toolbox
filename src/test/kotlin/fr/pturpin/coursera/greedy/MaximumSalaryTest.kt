package fr.pturpin.coursera.greedy
import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class MaximumSalaryTest {

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(21)
        maximumSalary.addDigits(2)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("221")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected2() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(9)
        maximumSalary.addDigits(4)
        maximumSalary.addDigits(6)
        maximumSalary.addDigits(1)
        maximumSalary.addDigits(9)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("99641")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected3() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(23)
        maximumSalary.addDigits(39)
        maximumSalary.addDigits(92)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("923923")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected4() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(21)
        maximumSalary.addDigits(1)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("211")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected5() {
        val maximumSalary = MaximumSalary()

        for (i in 0 until 100) {
            maximumSalary.addDigits(9)
        }
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected6() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(10)
        maximumSalary.addDigits(11)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("1110")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected7() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(10)
        maximumSalary.addDigits(1)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("110")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected8() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(10)
        maximumSalary.addDigits(0)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("100")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected9() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(10)
        maximumSalary.addDigits(2)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("210")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected10() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(10)
        maximumSalary.addDigits(10)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("1010")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected11() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(10)
        maximumSalary.addDigits(10)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("1010")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected12() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(96)
        maximumSalary.addDigits(907)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("96907")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected13() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(20)
        maximumSalary.addDigits(202)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("20220")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected14() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(85)
        maximumSalary.addDigits(858)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("85885")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected15() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(23)
        maximumSalary.addDigits(232)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("23232")
    }

    @Test
    fun getMaximumSalary_GivenSample_ReturnsExpected16() {
        val maximumSalary = MaximumSalary()

        maximumSalary.addDigits(23)
        maximumSalary.addDigits(2)
        val salary = maximumSalary.getMaximumSalary()

        assert(salary).isEqualTo("232")
    }

    @Test
    fun getMaximumSalary_StressTest_ReturnsExpected() {
        for (a in 0..1000) {
            for (b in 0..1000) {
                val candidate1 = (a.toString() + b.toString()).toInt()
                val candidate2 = (b.toString() + a.toString()).toInt()
                val expected = Math.max(candidate1, candidate2).toString()

                val maximumSalary = MaximumSalary()
                maximumSalary.addDigits(a)
                maximumSalary.addDigits(b)
                val salary = maximumSalary.getMaximumSalary()

                // println(a.toString() + "," + b)
                assert(salary).isEqualTo(expected)
            }
        }
    }

}
