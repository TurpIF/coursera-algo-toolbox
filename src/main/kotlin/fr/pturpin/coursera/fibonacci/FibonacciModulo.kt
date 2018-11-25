package fr.pturpin.coursera.fibonacci

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toLong() }

    val fibonacci = Fibonacci(n).getModulo(m.toInt())

    print(fibonacci)
}
