package fr.pturpin.coursera.greedy

import java.util.*

class MaximumSalary {

    private val allDigits = PriorityQueue<Int>(this::compareDigits)

    fun addDigits(digits: Int) {
        allDigits.add(digits)
    }

    fun getMaximumSalary(): String {
        var salary = ""
        while (allDigits.isNotEmpty()) {
            val digit = allDigits.remove()
            salary += digit.toString()
        }
        if (salary.all { it == '0' }) {
            return "0"
        }
        return salary
    }

    private fun compareDigits(left: Int, right: Int): Int {
        val strLeft = left.toString()
        val strRight = right.toString()

        val candidate1 = strLeft + strRight
        val candidate2 = strRight + strLeft

        return -candidate1.compareTo(candidate2)
    }

}

fun main(args: Array<String>) {
    val maximumSalary = MaximumSalary()

    readLine()!!
    readLine()!!.split(" ").map { it.toInt() }.forEach { maximumSalary.addDigits(it) }

    val salary = maximumSalary.getMaximumSalary()

    print(salary)
}
