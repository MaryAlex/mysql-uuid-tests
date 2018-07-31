package com.example.demo.model

import com.fasterxml.uuid.Generators
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.PrePersist
import javax.persistence.Table

@Entity
@Table(indexes = [Index(name = "IDX_MYIDX", columnList = "uuid")], name = "v1bin_entity")
data class V1BinEntity(
        @Column(columnDefinition = "BINARY(16)", name = "uuid")
        var uuid: UUID = Generators.timeBasedGenerator().generate()
) : SomeEntity() {
    override fun toString(): String {
        return "${super.toString()} id = ${this.id} smth = ${this.smth}"
    }

    constructor(id: Long, smth: String, uuid: UUID) : this(uuid) {
        this.id = id
        this.smth = smth
    }

    @PrePersist
    fun prePersist() {
        this.uuid = reorderUUID(this.uuid)
    }


    private fun reorderUUID(uuid: UUID) = UUID(reorderMostSigBits(uuid.mostSignificantBits), uuid.leastSignificantBits)

    private fun reorderMostSigBits(mostSigBits: Long) =
            (mostSigBits shl 48) or ((mostSigBits and 4294901760) shl 16) or (mostSigBits shr 32)
}