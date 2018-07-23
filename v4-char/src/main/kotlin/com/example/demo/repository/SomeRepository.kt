package com.example.demo.repository

import com.example.demo.model.SomeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SomeRepository : JpaRepository<SomeEntity, Long> {
    fun findByUuid(uuid: String)
}