package fr.pturpin.coursera.fibonacci

fun main(args: Array<String>) {
    val (m, n) = readLine()!!.split(" ").map { it.toLong() }

    val fibonacci = Fibonacci(n).getLastDigitOfSumFrom(m)

    print(fibonacci)
}
