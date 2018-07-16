package ar.com.acv2.acquarella.server.domain.types

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.BehaviorSpec
import java.time.LocalDate

internal class PastDateTest: BehaviorSpec( {

    Given("a date of yesterday"){
        val date = LocalDate.now().minusDays(1)
        When("use that date to build a pastdate"){
            val pastDate = PastDate(date)
            Then("type was build"){
                pastDate.value.shouldBe(LocalDate.now().minusDays(1))
            }
        }
    }


    Given("a date of today"){
        val date = LocalDate.now()
        When("use that date to build a pastdate"){
            val result = shouldThrow<IllegalArgumentException> { PastDate(date) }
            Then("pastdate's build has failed"){
                result.message.shouldBe("Value must be a date in the past")
            }
        }
    }

    Given("a date of tomorrow"){
        val date = LocalDate.now().plusDays(1)
        When("use that date to build a pastdate"){
            val result = shouldThrow<IllegalArgumentException> { PastDate(date) }
            Then("pastdate's build has failed"){
                result.message.shouldBe("Value must be a date in the past")
            }
        }
    }

})