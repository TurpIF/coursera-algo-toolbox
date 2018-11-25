package fr.pturpin.coursera.base

class SumOfTwoDigits(private val a: Int, private val b: Int) {

    fun getSum() = a + b

}

fun main(args: Array<String>) {
    val inputLine = readLine()!!
    val (a, b) = inputLine.split(' ').map { it.toInt() }

    val sumOfTwoDigits = SumOfTwoDigits(a, b)
    val sum = sumOfTwoDigits.getSum()

    print(sum)
}
