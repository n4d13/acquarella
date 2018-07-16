package ar.com.acv2.acquarella.server.domain.members.model

internal interface MemberRepository {

    fun createMember(prototype: Member.Prototype): Member

}