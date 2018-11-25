package fr.pturpin.coursera.divconquer
import assertk.assert
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

internal class MajorityElementTest {

    @Test
    fun getIdCandidateOfMajority_GivenSample_ReturnsExpected() {
        val majorityElement = MajorityElement()

        majorityElement.addVote(2)
        majorityElement.addVote(3)
        majorityElement.addVote(9)
        majorityElement.addVote(2)
        majorityElement.addVote(2)
        val hasAnyMajority = majorityElement.hasAnyMajority()

        assert(hasAnyMajority).isTrue()
    }

    @Test
    fun getIdCandidateOfMajority_GivenSample_ReturnsExpected2() {
        val majorityElement = MajorityElement()

        majorityElement.addVote(1)
        majorityElement.addVote(2)
        majorityElement.addVote(3)
        majorityElement.addVote(4)
        val hasAnyMajority = majorityElement.hasAnyMajority()

        assert(hasAnyMajority).isFalse()
    }

}
