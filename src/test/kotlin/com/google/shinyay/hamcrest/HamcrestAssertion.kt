package com.google.shinyay.hamcrest

import com.google.shinyay.service.HamcrestService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
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
}