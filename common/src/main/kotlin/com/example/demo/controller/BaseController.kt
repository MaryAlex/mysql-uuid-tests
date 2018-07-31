package com.example.demo.controller

import com.example.demo.model.SomeEntity
import com.example.demo.repository.BaseRepository
import org.springframework.web.bind.annotation.GetMapping
import java.util.logging.Logger

abstract class BaseController<T : SomeEntity, F>(private val someRepository: BaseRepository<T>) {
    abstract var currentUUID: F

    @GetMapping("/")
    fun hello() = "hello"

    @GetMapping("/create")
    fun create(): String {
        for (i in 1..N) {
            save()
            Logger.getGlobal().info("Round creating $i")
        }
        return "Done"
    }

    @GetMapping("/getUuid")
    abstract fun getUuid()

    @GetMapping("/select")
    fun select(): String {
        for (i in 1..N) {
            val result = repoSelect()
            Logger.getGlobal().info("Round selecting $i for id $currentUUID with result $result")
        }
        return "Done"
    }

    protected abstract fun getNew(): T
    protected abstract fun repoSelect(): T?
    fun save() = this.someRepository.save(getNew())
    open fun getObjectFromMiddle() = someRepository.findById(N / 2).get()

    companion object {
        const val N = 20000L
    }
}