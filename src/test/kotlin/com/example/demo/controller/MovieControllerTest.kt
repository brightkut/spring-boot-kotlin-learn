package com.example.demo.controller

import com.example.demo.model.Movie
import com.example.demo.service.MovieService
import com.example.demo.util.asJsonString
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest
class MovieControllerTest (@Autowired val mockMvc: MockMvc){
    @MockkBean
    private lateinit var movieService: MovieService;

    @Test
    fun insertMovie_success(){
        val mockMovie =  Movie("movie1","hary","adventure movie",50)
        every { movieService.insertMovie(any<Movie>()) } returns mockMovie

        mockMvc.post("/api/movies"){
            contentType = MediaType.APPLICATION_JSON
            content =  mockMovie.asJsonString()
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            //string
            content { mockMovie.asJsonString() }
        }
    }

    @Test
    fun insertMovie_failed_name_longer_than_5(){
        val mockMovie =  Movie("movie1","harry potter","adventure movie",50)
        every { movieService.insertMovie(any<Movie>()) } returns mockMovie

        mockMvc.post("/api/movies"){
            contentType = MediaType.APPLICATION_JSON
            content =  mockMovie.asJsonString()
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }
    }

    @Test
    fun insertMovie_failed_price_more_than_100(){
        val mockMovie =  Movie("movie1","har","adventure movie",500)
        every { movieService.insertMovie(any<Movie>()) } returns mockMovie

        mockMvc.post("/api/movies"){
            contentType = MediaType.APPLICATION_JSON
            content =  mockMovie.asJsonString()
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }
    }
}