package com.example.demo.controller

import com.example.demo.model.Movie
import com.example.demo.model.ResponseModel
import com.example.demo.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class MovieController(val movieService: MovieService) {

    @GetMapping("/movies")
    fun getMovies(): ResponseEntity<ResponseModel<List<Movie>>> {
        val responseModel = ResponseModel<List<Movie>>(1000).setDataObj(movieService.getMovies())

        return ResponseEntity.ok(responseModel)
    }

    @PostMapping("/movies")
    fun insertMovie(@RequestBody @Valid movie: Movie): ResponseEntity<ResponseModel<Movie>>{
        val responseModel = ResponseModel<Movie>(1000).setDataObj(movieService.insertMovie(movie))

        return ResponseEntity.ok(responseModel)
    }
}