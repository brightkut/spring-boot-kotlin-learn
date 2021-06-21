package com.example.demo.service

import com.example.demo.model.CinemaSub
import com.example.demo.repo.CinemaSubRepo
import org.springframework.stereotype.Service

@Service
class CinemaSubService(val cinemaSubRepo: CinemaSubRepo){

    fun getCinemaSub():List<CinemaSub>{
        return cinemaSubRepo.findAll()
    }

    fun insertCinemaSub(name: String):CinemaSub{
        val cinemaSub = CinemaSub(
                cinemaSubName = name
        )

        cinemaSubRepo.save(cinemaSub)

        return cinemaSub
    }
}