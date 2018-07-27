package com.example.demo.controller

import com.example.demo.model.V1BinNoOrderedEntity
import com.example.demo.repository.V1BinNoOrderedRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class MainController(@Autowired val v1BinNoOrderedRepository: V1BinNoOrderedRepository) : BaseController<V1BinNoOrderedEntity, UUID>(v1BinNoOrderedRepository) {
    override fun save() = v1BinNoOrderedRepository.saveCustom(getNew())

    override lateinit var currentUUID: UUID
    override fun repoSelect() = v1BinNoOrderedRepository.findByUuid(currentUUID)

    override fun getUuid() {
        currentUUID = getObjectFromMiddle().uuid
    }

    override fun getNew() = V1BinNoOrderedEntity()
}