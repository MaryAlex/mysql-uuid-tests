package com.example.demo.repository

import com.example.demo.model.V1BinEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface V1BinRepository : BaseRepository<V1BinEntity> {
    fun findByUuid(uuid: UUID): V1BinEntity?
}