package ar.com.acv2.acquarella.server.domain.test.actions

import ar.com.acv2.acquarella.server.domain.members.actions.CreateMember
import ar.com.acv2.acquarella.server.domain.members.model.Member
import ar.com.acv2.acquarella.server.domain.test.doubles.DummyMemberRepository
import ar.com.acv2.acquarella.server.domain.types.NonEmptyString15
import ar.com.acv2.acquarella.server.domain.types.NonEmptyString50
import ar.com.acv2.acquarella.server.domain.types.PastDate
import arrow.core.orElse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import java.time.LocalDate
import java.time.temporal.ChronoUnit

internal class CreateMemberTest: BehaviorSpec({

    Given("a valid member's prototype"){
        val prototype = Member.Prototype(NonEmptyString50("John Doe"), PastDate(LocalDate.now().minus(1, ChronoUnit.YEARS)),
                NonEmptyString15("1234567890"))
        When("use that prototype to build a member"){
            val memberList = mutableListOf<Member>()
            val member = CreateMember(DummyMemberRepository(memberList)).execute(prototype)
            Then("a valid member was created"){
                member.isSuccess().shouldBeTrue()
                member.map {
                    it.name.shouldBe(prototype.name)
                    it.birthDate.shouldBe(prototype.birthDate)
                    it.ssn.shouldBe(prototype.ssn)
                }.orElse {
                    throw RuntimeException("No member was returned")
                }
            }
        }
    }

})