package com.example.demo.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(indexes = [Index(name = "IDX_MYIDX", columnList = "uuid")])
data class V4CharEntity(
        @Column(columnDefinition = "CHAR(36)", name = "uuid")
        val uuid: String = UUID.randomUUID().toString()) : SomeEntity()
