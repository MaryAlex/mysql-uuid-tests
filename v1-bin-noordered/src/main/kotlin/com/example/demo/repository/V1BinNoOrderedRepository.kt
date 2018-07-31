package com.example.demo.repository

import com.example.demo.model.V1BinNoOrderedEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface V1BinNoOrderedRepository : BaseRepository<V1BinNoOrderedEntity> {
    fun findByUuid(uuid: UUID): V1BinNoOrderedEntity?
}