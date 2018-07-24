package com.example.demo.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(indexes = [Index(name = "IDX_MYIDX", columnList = "uuid")])
open class SomeEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var uuid: String = UUID.randomUUID().toString()
)
