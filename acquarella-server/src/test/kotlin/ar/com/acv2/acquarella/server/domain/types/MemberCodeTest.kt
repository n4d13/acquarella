package ar.com.acv2.acquarella.server.domain.types

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.BehaviorSpec

internal class MemberCodeTest: BehaviorSpec( {
    Given("a 32 characters string"){
        val code = "12345678901234567890123456789012"
        When("use that string to build a member's Code"){
            val memberCode = MemberCode(code)
            Then("A Member's code was build"){
                memberCode.value.shouldBe(code)
            }
        }
    }

    Given("a string compound by spaces"){
        val code = "                                "
        When("use that string to build a member's code"){
            val result = shouldThrow<IllegalArgumentException> { MemberCode(code) }
            Then("member's code build has failed"){
                result.message.shouldBe("Text can't be empty or blank")
            }
        }
    }

    Given("a empty string"){
        val code = ""
        When("use that string to build a member's code"){
            val result = shouldThrow<IllegalArgumentException> { MemberCode(code) }
            Then("member's code build has failed"){
                result.message.shouldBe("Text can't be empty or blank")
            }
        }
    }

    Given("a 31 characters string"){
        val code = "1234567890123456789012345678901"
        When("use that string to build a member's code"){
            val result = shouldThrow<IllegalArgumentException> { MemberCode(code) }
            Then("member's code build has failed"){
                result.message.shouldBe("Member's code must have 32 characters")
            }
        }
    }

    Given("a 33 characters string"){
        val code = "123456789012345678901234567890123"
        When("use that string to build a member's code"){
            val result = shouldThrow<IllegalArgumentException> { MemberCode(code) }
            Then("member's code build has failed"){
                result.message.shouldBe("Member's code must have 32 characters")
            }
        }
    }
})