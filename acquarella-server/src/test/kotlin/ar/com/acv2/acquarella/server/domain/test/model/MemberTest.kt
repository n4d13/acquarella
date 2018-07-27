package ar.com.acv2.acquarella.server.domain.test.model

import ar.com.acv2.acquarella.server.domain.members.model.Member
import ar.com.acv2.acquarella.server.domain.types.*
import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import java.time.LocalDate

internal class MemberTest : BehaviorSpec({

    Given("a valid set of data to build a member"){
        val id = Id(1)
        val code = MemberCode("12345678901234567890123456789012")
        val name = NonEmptyString50("John Doe")
        val birthDate = PastDate(LocalDate.now().minusYears(10))
        val ssn = NonEmptyString15("1234567890")
        When("use that data to build a Member type"){
            val member = Member(id, code, name, birthDate, ssn)
            Then("Member's build was successful"){
                member.id.value.shouldBe(1)
                member.code.value.shouldBe("12345678901234567890123456789012")
                member.name.text.shouldBe("John Doe")
                member.birthDate.value.shouldBe(LocalDate.now().minusYears(10))
                member.ssn.text.shouldBe("1234567890")
            }
        }
    }

    Given("a valid set of data to build a Member.Prototype"){
        val name = NonEmptyString50("John Doe")
        val birthDate = PastDate(LocalDate.now().minusYears(10))
        val ssn = NonEmptyString15("1234567890")
        When("use that data to build a Member.Prototype type"){
            val prototype = Member.Prototype(name, birthDate, ssn)
            Then("Member.Prototype's build was successful"){
                prototype.name.text.shouldBe("John Doe")
                prototype.birthDate.value.shouldBe(LocalDate.now().minusYears(10))
                prototype.ssn.text.shouldBe("1234567890")
            }
        }
    }
})
