package com.example.demo.controller

import com.example.demo.model.Movie
import com.example.demo.model.ResponseModel
import com.example.demo.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
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

    @GetMapping("/test-validate-header")
    // @NotNull can use without @Validated
    // @Size need to add @ Validated
    fun validateHeader(@RequestHeader @NotNull @Size(min =1 , max=3) auth: String):String{
        return auth
    }
}