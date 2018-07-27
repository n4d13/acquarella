package ar.com.acv2.acquarella.server.domain.test.types

import ar.com.acv2.acquarella.server.domain.types.NonEmptyString15
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.BehaviorSpec

internal class NonEmptyString15Test: BehaviorSpec( {

    Given("a 1 character string"){
        val text = "a"
        When("build a NonEmptyString15 type"){
            val type = NonEmptyString15(text)
            Then("that type was build"){
                type.text.shouldBe("a")
            }
        }
    }

    Given("a 15 characters string"){
        val text = "aaaaaaaaaaaaaaa"
        When("build a NonEmptyString15 type"){
            val type = NonEmptyString15(text)
            Then("that type was build"){
                type.text.shouldBe("aaaaaaaaaaaaaaa")
            }
        }
    }

    Given("a 16 characters string"){
        val text = "aaaaaaaaaaaaaaaa"
        When("build a NonEmptyString15 type"){
            val result = shouldThrow<IllegalArgumentException> { NonEmptyString15(text) }
            Then("type's build has failed"){
                result.message.shouldBe("Text can't be longer than 15 characters")
            }
        }
    }

    Given("a empty string"){
        val text = ""
        When("build a NonEmptyString15 type"){
            val result = shouldThrow<IllegalArgumentException> { NonEmptyString15(text) }
            Then("type's build has failed"){
                result.message.shouldBe("Text can't be empty or blank")
            }
        }
    }

    Given("a blank string"){
        val text = "               "
        When("build a NonEmptyString15 type"){
            val result = shouldThrow<IllegalArgumentException> { NonEmptyString15(text) }
            Then("type's build has failed"){
                result.message.shouldBe("Text can't be empty or blank")
            }
        }
    }

})