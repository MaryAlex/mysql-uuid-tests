package com.example.demo.controller

import com.example.demo.model.SomeEntity
import com.example.demo.repository.BaseRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.logging.Logger

abstract class BaseController<T : SomeEntity>(private val someRepository: BaseRepository<T>) {
    @GetMapping("/")
    fun hello() = "hello"

    @GetMapping("/create")
    fun create(): String {
        for (i in 1..N) {
            someRepository.save(getNew())
            Logger.getGlobal().info("Round creating $i")
        }
        return "Done"
    }

    @GetMapping("/getUuid")
    fun getUuid() = someRepository.findById(N / 2).get().uuid

    @GetMapping("/select")
    fun select(@RequestParam uuid: String): String {
        for (i in 1..N) {
            someRepository.findByUuid(uuid)
            Logger.getGlobal().info("Round selecting $i for id $uuid")
        }
        return "Done"
    }

    protected abstract fun getNew(): T

    companion object {
        const val N = 200000L
    }
}