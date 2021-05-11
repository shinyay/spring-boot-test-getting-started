package com.google.shinyay.hamcrest

import com.google.shinyay.service.HamcrestService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test

class HamcrestAssertion {

    private val hamcrestService = HamcrestService()

//    Basic ---------------------------------------------------------------

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

//    String ---------------------------------------------------------------

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

    // hasItems()
    @Test
    fun shouldHaveAllItems() {
        assertThat(hamcrestService.returnStringList(), `is`(hasItems("Bob")))
    }

    // hasItems()
    @Test
    fun shouldHaveSize() {
        assertThat(hamcrestService.returnStringList(), `is`(hasSize(3)))
    }

//    Number ---------------------------------------------------------------

    // closeTo()
    @Test
    fun shouldBeInRange() {
        assertThat(hamcrestService.returnRandomDoubleNumber(), `is`(closeTo(0.0, 10.0)))
    }

    // greaterThan() or greaterThanOrEqualTo()
    @Test
    fun shouldBeGreater() {
        assertThat(hamcrestService.returnRandomIntNumber(), `is`(greaterThanOrEqualTo(1)))
    }

    // lessThanOrEqualTo()
    @Test
    fun shouldBeLess() {
        assertThat(hamcrestService.returnRandomIntNumber(), `is`(lessThanOrEqualTo(10)))
    }

//    ---------------------------------------------------------------

    // hasProperty()
    @Test
    fun shouldHaveProperty() {
        assertThat(hamcrestService.returnGirl(), `is`(hasProperty("name")))
        assertThat(hamcrestService.returnGirl(), `is`(hasProperty("age")))
        assertThat(hamcrestService.returnGirl(), `is`(hasProperty("age", greaterThanOrEqualTo(20))))
    }

    @Test
    fun shouldHaveAllSameProperties() {
        assertThat(hamcrestService.returnGirl(), `is`(samePropertyValuesAs(hamcrestService.returnPeople("Alice", 20, "Female"))))
        assertThat(hamcrestService.returnGirl(), `is`(samePropertyValuesAs(hamcrestService.returnPeople("Carol", 20, "Female"), "name")))
    }

}