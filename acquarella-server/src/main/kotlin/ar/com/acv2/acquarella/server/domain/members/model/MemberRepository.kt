package ar.com.acv2.acquarella.server.domain.members.model

import arrow.core.Try

internal interface MemberRepository {

    fun createMember(prototype: Member.Prototype): Try<Member>

}