package com.example.demo.service

import com.example.demo.model.Cinema
import com.example.demo.repo.CinemaRepo
import org.springframework.stereotype.Service

@Service
class CinemaService (val cinemaRepo: CinemaRepo){
    fun insertCinema(cinema: Cinema):Cinema{
        cinemaRepo.save(cinema)

        return cinema
    }
}