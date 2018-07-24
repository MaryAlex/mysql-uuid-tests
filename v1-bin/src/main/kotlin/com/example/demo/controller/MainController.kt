package com.example.demo.controller

import com.example.demo.model.OtherEntity
import com.example.demo.repository.OtherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(@Autowired otherRepository: OtherRepository) : BaseController<OtherEntity>(otherRepository) {
    override fun getNew() = OtherEntity()
}