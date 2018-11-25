package fr.pturpin.coursera.dynprog
import assertk.assert
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class PrimitiveCalculatorTest {

    @Test
    fun getMinimumOperationsToCompute_GivenSample_ReturnsExpected() {
        val primitiveCalculator = PrimitiveCalculator(1)

        val minimumOperationsToCompute = primitiveCalculator.getMinimumOperationsToCompute()
        val listOfState = minimumOperationsToCompute.getStates().toList().reversed()

        assert(listOfState).containsExactly(1)
        assert(minimumOperationsToCompute.size()).isEqualTo(0)
    }

    @Test
    fun getMinimumOperationsToCompute_GivenSample_ReturnsExpected2() {
        val primitiveCalculator = PrimitiveCalculator(5)

        val minimumOperationsToCompute = primitiveCalculator.getMinimumOperationsToCompute()
        val listOfState = minimumOperationsToCompute.getStates().toList().reversed()

        assert(listOfState).containsExactly(1, 2, 4, 5)
        assert(minimumOperationsToCompute.size()).isEqualTo(3)
    }

    @Test
    fun getMinimumOperationsToCompute_GivenSample_ReturnsExpected3() {
        val primitiveCalculator = PrimitiveCalculator(96234)

        val minimumOperationsToCompute = primitiveCalculator.getMinimumOperationsToCompute()
        val listOfState = minimumOperationsToCompute.getStates().toList().reversed()

        assert(listOfState).containsExactly(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234)
        assert(minimumOperationsToCompute.size()).isEqualTo(14)
    }

    @Test
    fun getMinimumOperationsToCompute_GivenSample_ReturnsExpected4() {
        val primitiveCalculator = PrimitiveCalculator(11)

        val minimumOperationsToCompute = primitiveCalculator.getMinimumOperationsToCompute()
        val listOfState = minimumOperationsToCompute.getStates().toList().reversed()

        assert(listOfState).containsExactly(1, 3, 9, 10, 11)
        assert(minimumOperationsToCompute.size()).isEqualTo(4)
    }

    @Test
    fun getMinimumOperationsToCompute_GivenBig_ReturnsExpected() {
        val primitiveCalculator = PrimitiveCalculator(1_000_000)

        val minimumOperationsToCompute = primitiveCalculator.getMinimumOperationsToCompute()
        val size = minimumOperationsToCompute.size()

        assert(minimumOperationsToCompute.getStates().toList().size).isEqualTo(20)
        assert(size).isEqualTo(19)
    }
}
