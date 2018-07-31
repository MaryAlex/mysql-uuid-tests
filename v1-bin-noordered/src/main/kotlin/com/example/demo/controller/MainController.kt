package com.example.demo.controller

import com.example.demo.model.V1BinNoOrderedEntity
import com.example.demo.repository.V1BinNoOrderedRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class MainController(@Autowired val v1BinNoOrderedRepository: V1BinNoOrderedRepository) : BaseController<V1BinNoOrderedEntity, UUID>(v1BinNoOrderedRepository) {
    override lateinit var currentUUID: UUID
    override fun repoSelect() = v1BinNoOrderedRepository.findByUuid(currentUUID)

    override fun getUuid() {
        currentUUID = getObjectFromMiddle().uuid
    }

    override fun getNew() = V1BinNoOrderedEntity()

    @GetMapping("/smthHere")
    fun smthHere() = UUID.randomUUID()

    @GetMapping("/smthThere")
    fun smthThere(@RequestParam uuid: UUID) = uuid
}