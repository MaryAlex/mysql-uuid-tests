package com.example.demo.controller

import com.example.demo.model.V4CharEntity
import com.example.demo.repository.V4CharRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(@Autowired val v4CharRepository: V4CharRepository) : BaseController<V4CharEntity, String>(v4CharRepository) {
    override fun save() = v4CharRepository.saveCustom(getNew())
    override lateinit var currentUUID: String
    override fun repoSelect() = v4CharRepository.findByUuid(currentUUID)
    override fun getUuid() {
        currentUUID = getObjectFromMiddle().uuid
    }

    override fun getNew() = V4CharEntity()
}