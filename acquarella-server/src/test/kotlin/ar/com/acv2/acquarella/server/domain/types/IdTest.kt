package ar.com.acv2.acquarella.server.domain.types

import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.BehaviorSpec

internal class IdTest : BehaviorSpec({

    Given("a value greater than zero"){
        val idValue = 1
        When("build a IdType"){
            val idType = Id(idValue)
            Then("Type was created"){
                idType.shouldBeInstanceOf<Id>()
                idType.value.shouldBe(idValue)
            }
        }
    }

    Given("a value lower than zero"){
        val idValue = -1
        When("build a idType"){
            val result = shouldThrow<IllegalArgumentException> { Id(idValue) }
            Then("Type creation has failed"){
                result.message.shouldBe("Id must be greater than zero")
            }
        }
    }

    Given("a value equals to zero"){
        val idValue = 0
        When("build a idType"){
            val result = shouldThrow<IllegalArgumentException> { Id(idValue) }
            Then("Type creation has failed"){
                result.message.shouldBe("Id must be greater than zero")
            }
        }
    }
})

