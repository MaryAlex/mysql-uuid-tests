package com.example.demo.controller

import com.example.demo.model.V4BinEntity
import com.example.demo.repository.V4BinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class MainController(@Autowired val v4BinRepository: V4BinRepository) : BaseController<V4BinEntity, UUID>(v4BinRepository) {
    override lateinit var currentUUID: UUID

    override fun repoSelect(): V4BinEntity? {
        return v4BinRepository.findByUuid(currentUUID)
    }

    override fun getUuid() {
        currentUUID = getObjectFromMiddle().uuid
    }

    override fun getNew() = V4BinEntity()
}
