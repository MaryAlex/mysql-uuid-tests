package com.example.demo.controller

import com.example.demo.model.V1BinEntity
import com.example.demo.repository.V1BinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(@Autowired val v1BinRepository: V1BinRepository) : BaseController<V1BinEntity, String>(v1BinRepository) {
    override fun save() = v1BinRepository.saveCustom(getNew())
    override lateinit var currentUUID: String
    override fun repoSelect() = v1BinRepository.findByUuid(currentUUID)
    override fun getObjectFromMiddle() = v1BinRepository.findByIdCustom(N / 2).get()

    override fun getUuid() {
        currentUUID = getObjectFromMiddle().uuid
    }

    override fun getNew() = V1BinEntity()
}