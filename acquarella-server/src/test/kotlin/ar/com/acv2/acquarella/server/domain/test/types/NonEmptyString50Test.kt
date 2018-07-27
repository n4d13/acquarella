package ar.com.acv2.acquarella.server.domain.test.types

import ar.com.acv2.acquarella.server.domain.types.NonEmptyString50
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.BehaviorSpec

internal class NonEmptyString50Test: BehaviorSpec( {

    Given("a 1 character string"){
        val text = "a"
        When("build a NonEmptyString50 type"){
            val type = NonEmptyString50(text)
            Then("that type was build"){
                type.text.shouldBe("a")
            }
        }
    }

    Given("a 50 characters string"){
        val text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        When("build a NonEmptyString50 type"){
            val type = NonEmptyString50(text)
            Then("that type was build"){
                type.text.shouldBe("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            }
        }
    }

    Given("a 51 characters string"){
        val text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        When("build a NonEmptyString50 type"){
            val result = shouldThrow<IllegalArgumentException> { NonEmptyString50(text) }
            Then("type's build has failed"){
                result.message.shouldBe("Text can't be longer than 50 characters")
            }
        }
    }

    Given("a empty string"){
        val text = ""
        When("build a NonEmptyString50 type"){
            val result = shouldThrow<IllegalArgumentException> { NonEmptyString50(text) }
            Then("type's build has failed"){
                result.message.shouldBe("Text can't be empty or blank")
            }
        }
    }

    Given("a blank string"){
        val text = "               "
        When("build a NonEmptyString50 type"){
            val result = shouldThrow<IllegalArgumentException> { NonEmptyString50(text) }
            Then("type's build has failed"){
                result.message.shouldBe("Text can't be empty or blank")
            }
        }
    }

})