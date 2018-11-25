package fr.pturpin.coursera.gcd

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }

    val lcm = GreatestCommonDivisor(a, b).getLcm()

    print(lcm)
}
