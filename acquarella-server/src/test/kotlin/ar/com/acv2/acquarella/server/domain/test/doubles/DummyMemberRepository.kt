package ar.com.acv2.acquarella.server.domain.test.doubles

import ar.com.acv2.acquarella.server.domain.members.model.Member
import ar.com.acv2.acquarella.server.domain.members.model.MemberRepository
import ar.com.acv2.acquarella.server.domain.types.Id
import ar.com.acv2.acquarella.server.domain.types.MemberCode
import arrow.core.Try

internal class DummyMemberRepository : MemberRepository {

    override fun createMember(prototype: Member.Prototype): Try<Member> {
        return Try {
            Member(Id(1), MemberCode("12345678901234567890123456789012"),
                    prototype.name, prototype.birthDate, prototype.ssn)
        }
    }
}