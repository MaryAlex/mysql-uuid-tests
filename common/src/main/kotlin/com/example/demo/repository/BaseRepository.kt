package com.example.demo.repository

import com.example.demo.model.SomeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BaseRepository<T : SomeEntity> : JpaRepository<T, Long> {
    fun findByUuid(uuid: String)
}