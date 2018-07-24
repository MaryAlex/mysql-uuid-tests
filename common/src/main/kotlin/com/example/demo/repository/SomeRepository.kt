package com.example.demo.repository

import com.example.demo.model.SomeEntity
import org.springframework.stereotype.Repository

@Repository
interface SomeRepository : BaseRepository<SomeEntity>
