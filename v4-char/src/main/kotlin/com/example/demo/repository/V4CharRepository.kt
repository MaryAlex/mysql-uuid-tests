package com.example.demo.repository

import com.example.demo.model.V4CharEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface V4CharRepository : BaseRepository<V4CharEntity> {
    fun findByUuid(uuid: String) : V4CharEntity?

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO v4char_entity (smth,uuid) VALUES(:#{#p0.smth}, :#{#p0.uuid})", nativeQuery = true)
    fun saveCustom(@Param("p0") p0: V4CharEntity)
}