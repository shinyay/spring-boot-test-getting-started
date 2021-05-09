package com.google.shinyay.hamcrest

import com.google.shinyay.service.HamcrestService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test

class HamcrestAssertion {

    private val hamcrestService = HamcrestService()

    // is()
    @Test
    fun sameValue() {
        assertThat(hamcrestService.returnStringValue(), `is`("foo"))
    }

    // not()
    @Test
    fun notSameValue() {
        assertThat(hamcrestService.returnStringValue(), `is`(not("bar")))
    }

    // startsWith()
    @Test
    fun startCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(startsWith("f")))
    }

    // endsWith()
    @Test
    fun endCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(endsWith("o")))
    }

    // containsString()
    @Test
    fun containCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(containsString("fo")))
    }

    // equalToIgnoringCase()
    @Test
    fun ignoreCaseCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(equalToIgnoringCase("FOO")))
    }

    // emptyString() or emptyOrNullString()
    @Test
    fun shouldHaveBlank() {
        assertThat(hamcrestService.returnBlank(), `is`(emptyString()))
    }

    // stringContainsInOrder()
    @Test
    fun shouldBeInOrder() {
        assertThat(hamcrestService.returnStringList().toString(), `is`(stringContainsInOrder("Alice", "Bob", "Carol")))
    }


    // containsInAnyOrder()
    @Test
    fun shouldBeInAnyOrder() {
        assertThat(hamcrestService.returnStringList(), `is`(containsInAnyOrder("Carol", "Bob", "Alice")))
    }

    // hasItem()
    @Test
    fun shouldHaveItem() {
        assertThat(hamcrestService.returnStringList(), `is`(hasItem("Bob")))
    }
//    ---------------------------------------------------------------

    // greaterThan() or greaterThanOrEqualTo()
    @Test
    fun shouldBeGreater() {
        assertThat(hamcrestService.returnRandomNumber(), `is`(greaterThanOrEqualTo(1)))
    }

    // lessThanOrEqualTo()
    @Test
    fun shouldBeLess() {
        assertThat(hamcrestService.returnRandomNumber(), `is`(lessThanOrEqualTo(10)))
    }

}