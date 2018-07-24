package com.example.demo.model

import com.fasterxml.uuid.Generators
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(indexes = [Index(name = "IDX_MYIDX", columnList = "uuid")])
class OtherEntity(
        uuid: String = Generators.timeBasedGenerator().generate().toString()
) : SomeEntity(uuid = uuid)
