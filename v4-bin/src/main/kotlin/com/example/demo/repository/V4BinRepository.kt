package com.example.demo.repository

import com.example.demo.model.V4BinEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Repository
interface V4BinRepository : BaseRepository<V4BinEntity> {
    fun findByUuid(uuid: UUID): V4BinEntity?

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO v4bin_entity (smth,uuid) VALUES(:#{#p0.smth}, :#{#p0.uuid})", nativeQuery = true)
    fun saveCustom(@Param("p0") p0: V4BinEntity)
}