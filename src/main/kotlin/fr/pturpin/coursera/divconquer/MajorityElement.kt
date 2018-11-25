package fr.pturpin.coursera.divconquer

class MajorityElement {

    private val votesPerCandidates = mutableMapOf<Int, Int>()

    fun addVote(idCandidate: Int) {
        votesPerCandidates.compute(idCandidate) { _, currentNbVotes -> (currentNbVotes ?: 0) + 1}
    }

    fun hasAnyMajority(): Boolean {
        if (votesPerCandidates.isEmpty()) {
            return false
        }

        val nbVotes = votesPerCandidates.values.max()!!
        val nbTotalVotes = votesPerCandidates.values.sum()

        return nbVotes > nbTotalVotes / 2
    }

}

fun main(args: Array<String>) {
    val majorityElement = MajorityElement()

    readLine()!!
    readLine()!!.split(" ").map { it.toInt() }.forEach { majorityElement.addVote(it) }

    val hasAnyMajority = majorityElement.hasAnyMajority()
    val output = if (hasAnyMajority) "1" else "0"

    print(output)
}
