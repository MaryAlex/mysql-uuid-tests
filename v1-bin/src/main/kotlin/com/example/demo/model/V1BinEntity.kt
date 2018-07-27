package com.example.demo.model

import com.fasterxml.uuid.Generators
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(indexes = [Index(name = "IDX_MYIDX", columnList = "uuid")], name = "v1bin_entity")
data class V1BinEntity(
        @Column(columnDefinition = "BINARY(16)", name = "uuid")
        val uuid: String = Generators.timeBasedGenerator().generate().toString()
) : SomeEntity() {
    override fun toString(): String {
        return "${super.toString()} id = ${this.id} smth = ${this.smth}"
    }

    constructor(id: Long, smth: String, uuid: String) : this(uuid) {
        this.id = id
        this.smth = smth
    }
}