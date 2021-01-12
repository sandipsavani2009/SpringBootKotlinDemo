package com.test.sandipapi.demo.restControllers

import com.test.sandipapi.demo.dto.Mobile
import com.test.sandipapi.demo.dto.response.TestResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ValidateMobileNumberController {

    @PostMapping("/mobile",
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun printMobile(@RequestBody mobile: Mobile?): ResponseEntity<TestResponse?> {

        val testResponse = TestResponse()
        mobile?.let {
            if (mobile.number?.isEmpty()
                    || mobile.number == "0000000000"
                    || mobile.number!!.length != 10
                    || !mobile.number.all { Character.isDigit(it) }) {
                testResponse.str = "Invalid mobile number"
            } else {
                testResponse.str = "Yah, Its valid mobile number!!"
            }
        } ?:let {
            testResponse.str = "No request body"
        }

        val headers = HttpHeaders()
        headers.add("Test1","t1")
        headers.add("Test2", "{}{}")

        return ResponseEntity<TestResponse?>(testResponse, headers, HttpStatus.OK)
    }

}