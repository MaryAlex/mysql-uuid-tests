package com.example.demo.model

import com.fasterxml.uuid.Generators
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(indexes = [Index(name = "IDX_MYIDX", columnList = "uuid")])
data class V1BinNoOrderedEntity(
        @Column(columnDefinition = "BINARY(16)")
        val uuid: UUID = Generators.timeBasedGenerator().generate()
) : SomeEntity() {
    override fun toString(): String {
        return "${super.toString()} id = ${this.id} smth = ${this.smth}"
    }
}