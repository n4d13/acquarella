package ar.com.acv2.acquarella.server.domain.members.model

import ar.com.acv2.acquarella.server.domain.types.*

internal data class Member(val id: Id, val code: MemberCode, val name: NonEmptyString50, val birthDate: PastDate, val ssn: NonEmptyString15){

    internal data class Prototype(val name: NonEmptyString50, val birthDate: PastDate, val ssn: NonEmptyString15)
}