package com.test.sandipapi.demo.restControllers

import com.test.sandipapi.demo.dto.Greeting
import com.test.sandipapi.demo.dto.Mobile
import com.test.sandipapi.demo.dto.response.TestResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.function.ServerRequest

@RestController
class GreetingsTestController {

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String?): Greeting? {
        return Greeting(1 , "Hello $name")
    }

}