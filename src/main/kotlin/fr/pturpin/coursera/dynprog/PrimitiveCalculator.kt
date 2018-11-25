package fr.pturpin.coursera.dynprog

class PrimitiveCalculator(private val number: Int) {

    private val availableOperations = listOf(
        MultByOperation(2),
        MultByOperation(3),
        AddToOperation(1)
    )

    private val cache = mutableMapOf<Int, OperationStates>()

    fun getMinimumOperationsToCompute(): OperationStates {
        cache.clear()
        cache[1] = NoOpStates(1)

        for (currentNumber in 1..number) {
            val currentOperation = cache[currentNumber]!!

            availableOperations.forEach {
                val appliedNumber = it.apply(currentNumber)
                cache.compute(appliedNumber) { _, oldState ->
                    val newState = LinkedOperationStates(
                        appliedNumber,
                        currentOperation
                    )
                    if (oldState == null || newState.size() < oldState.size()) {
                        newState
                    } else {
                        oldState
                    }
                }
                if (appliedNumber == number) {
                    return cache[number]!!
                }
            }
        }

        return cache[number]!!
    }

    private interface Operation {
        fun apply(number: Int): Int
    }

    private class MultByOperation(private val factor: Int) :
        Operation {
        override fun apply(number: Int): Int {
            return number * factor
        }
    }

    private class AddToOperation(private val term: Int) :
        Operation {
        override fun apply(number: Int): Int {
            return number + term
        }

    }

    interface OperationStates {
        fun size(): Int
        fun getStates(): Iterable<Int>
    }

    private class LinkedOperationStates(
        private val currentState: Int,
        private val nextState: OperationStates
    )
        : OperationStates {

        private val size = nextState.size() + 1

        override fun size() = size

        override fun getStates(): Iterable<Int> {
            return listOf(currentState) + nextState.getStates()
        }
    }

    private class NoOpStates(private val initialValue: Int):
        OperationStates {
        override fun size() = 0

        override fun getStates() = listOf(initialValue)
    }

}

fun main(args: Array<String>) {
    val number = readLine()!!.toInt()

    val primitiveCalculator = PrimitiveCalculator(number)
    val minimumOperationsToCompute = primitiveCalculator.getMinimumOperationsToCompute()

    println(minimumOperationsToCompute.size())
    print(minimumOperationsToCompute.getStates().reversed().joinToString(" "))
}
