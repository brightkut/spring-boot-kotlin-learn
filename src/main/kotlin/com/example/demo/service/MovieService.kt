package com.example.demo.service

import com.example.demo.model.Movie
import com.example.demo.repo.MovieRepo
import org.springframework.stereotype.Service

@Service
class MovieService (val movieRepo: MovieRepo){

    fun getMovies (): List<Movie>{

        return movieRepo.findAll()
    }

    fun insertMovie(movie: Movie):Movie{
        movieRepo.save(movie)

        return movie
    }

    fun updateMovieName(id:String,name : String): Movie{
        movieRepo.updateMovieName(id,name)

        return movieRepo.getById(id)
    }
}