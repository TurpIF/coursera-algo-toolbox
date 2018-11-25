package fr.pturpin.coursera.gcd

class GreatestCommonDivisor(private val a: Long, private val b: Long) {

    fun get() = computeGcd(a, b)

    fun getLcm(): Long {
        val gcd = get()
        return (a / gcd) * b
    }

    private fun computeGcd(a: Long, b: Long): Long {
        if (b == 0L) {
            return a
        }
        val rem = a.rem(b)
        return computeGcd(b, rem)
    }

}

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }

    val gcd = GreatestCommonDivisor(a, b).get()

    print(gcd)
}
