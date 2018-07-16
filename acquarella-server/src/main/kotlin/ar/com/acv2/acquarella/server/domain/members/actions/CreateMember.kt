package ar.com.acv2.acquarella.server.domain.members.actions

import ar.com.acv2.acquarella.server.domain.members.model.Member
import ar.com.acv2.acquarella.server.domain.members.model.MemberRepository

internal class CreateMember(private val repository: MemberRepository) {

    fun execute(prototype: Member.Prototype): Member {
        return repository.createMember(prototype)
    }

}