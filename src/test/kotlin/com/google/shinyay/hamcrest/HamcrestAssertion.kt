package com.google.shinyay.hamcrest

import com.google.shinyay.service.HamcrestService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class HamcrestAssertion {

    private val hamcrestService = HamcrestService()

    @Test
    fun sameValue() {
        assertThat(hamcrestService.returnStringValue(), `is`("foo"))
    }

    @Test
    fun notSameValue() {
        assertThat(hamcrestService.returnStringValue(), `is`(not("bar")))
    }

    @Test
    fun startCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(startsWith("f")))
    }

    @Test
    fun endCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(endsWith("o")))
    }

    @Test
    fun containCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(containsString("fo")))
    }

    @Test
    fun ignoreCaseCharacter() {
        assertThat(hamcrestService.returnStringValue(), `is`(equalToIgnoringCase("FOO")))
    }

    @Test
    fun shouldHaveBlank() {
        assertThat(hamcrestService.returnBlank(), `is`(emptyString()))
    }
}