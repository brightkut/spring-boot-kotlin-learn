package com.example.demo.controller

import com.example.demo.model.CinemaSub
import com.example.demo.model.ResponseModel
import com.example.demo.service.CinemaSubService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CinemaSubController (val cinemaSubService: CinemaSubService){

    @GetMapping("/cinemaSubs")
    fun getCinemaSub(): ResponseEntity<ResponseModel<List<CinemaSub>>> {
        val responseModel = ResponseModel<List<CinemaSub>>(1000).setDataObj(cinemaSubService.getCinemaSub())

        return ResponseEntity.ok(responseModel)
    }

    @PostMapping("/cinemaSubs")
    fun insertCinemaSub(@RequestParam(name = "name")name: String): ResponseEntity<ResponseModel<CinemaSub>>{
        val responseModel = ResponseModel<CinemaSub>(1000).setDataObj(cinemaSubService.insertCinemaSub(name))

        return ResponseEntity.ok(responseModel)
    }
}