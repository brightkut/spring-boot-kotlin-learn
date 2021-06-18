package com.example.demo.controller

import com.example.demo.model.Cinema
import com.example.demo.model.ResponseModel
import com.example.demo.service.CinemaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CinemaController(val cinemaService: CinemaService) {

    @PostMapping("/cinemas")
    fun insertCinema(@RequestBody @Valid cinema: Cinema): ResponseEntity<ResponseModel<Cinema>> {
        val responseModel = ResponseModel<Cinema>(1000).setDataObj(cinemaService.insertCinema(cinema))

        return ResponseEntity.ok(responseModel)
    }
}