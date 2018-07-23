package com.example.demo.controller

import com.example.demo.model.SomeEntity
import com.example.demo.repository.SomeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
class MainController(@Autowired private val someRepository: SomeRepository) {
    @GetMapping("/")
    fun hello() = "hello"

    @GetMapping("/create")
    fun create(): String {
        for (i in 1..200000) {
            someRepository.save(SomeEntity())
            Logger.getGlobal().info("Round v4-char $i")
        }
        return "Done"
    }

    @GetMapping("/select")
    fun select(): String {
        for (i in 1..1000000) {
            someRepository.findByUuid("2949ce96-2484-4ffc-828f-5d2bd22b47e2")
            Logger.getGlobal().info("Round some $i")
        }
        return "Done"
    }
}