package com.example.demo.repository

import com.example.demo.model.V1BinEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Repository
interface V1BinRepository : BaseRepository<V1BinEntity> {
    @Query("SELECT id, smth, BIN_TO_UUID(uuid) as uuid FROM v1bin_entity WHERE uuid = UUID_TO_BIN(?)", nativeQuery = true)
    fun findByUuid(uuid: String): V1BinEntity?

    @Query("SELECT id, smth, BIN_TO_UUID(uuid) as uuid FROM v1bin_entity WHERE id =  ?", nativeQuery = true)
    fun findByIdCustom(p0: Long): Optional<V1BinEntity>

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO v1bin_entity (smth,uuid) VALUES(:#{#p0.smth}, UUID_TO_BIN(:#{#p0.uuid}))", nativeQuery = true)
    fun saveCustom(@Param("p0") p0: V1BinEntity)
}