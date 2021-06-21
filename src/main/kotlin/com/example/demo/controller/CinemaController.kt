package com.example.demo.controller

import com.example.demo.model.Cinema
import com.example.demo.model.ResponseModel
import com.example.demo.service.CinemaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CinemaController(val cinemaService: CinemaService) {

    @PostMapping("/cinemas")
    fun insertCinema(@RequestBody @Valid cinema: Cinema): ResponseEntity<ResponseModel<Cinema>> {
        val responseModel = ResponseModel<Cinema>(1000).setDataObj(cinemaService.insertCinema(cinema))

        return ResponseEntity.ok(responseModel)
    }

    @GetMapping("/cinemas/names/{name}")
    fun getByCinemaName(@PathVariable name:String): ResponseEntity<ResponseModel<Cinema>> {
        val responseModel = ResponseModel<Cinema>(1000).setDataObj(cinemaService.getByName(name))

        return ResponseEntity.ok(responseModel)
    }


    @GetMapping("/cinemas/subs/{subId}")
    fun getByCinemaSubId(@PathVariable subId:Int): ResponseEntity<ResponseModel<Cinema?>> {
        val responseModel = ResponseModel<Cinema>(1000).setDataObj(cinemaService.getByCinemaSubId(subId))

        return ResponseEntity.ok(responseModel)
    }
}