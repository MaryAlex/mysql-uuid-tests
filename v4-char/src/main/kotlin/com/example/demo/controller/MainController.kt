package com.example.demo.controller

import com.example.demo.model.SomeEntity
import com.example.demo.repository.SomeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(@Autowired someRepository: SomeRepository) : BaseController<SomeEntity>(someRepository) {
    override fun getNew() = SomeEntity()
}