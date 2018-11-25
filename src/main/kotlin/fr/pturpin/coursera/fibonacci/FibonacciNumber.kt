package fr.pturpin.coursera.fibonacci

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()

    val fibonacci = Fibonacci(n).get()

    print(fibonacci)
}
