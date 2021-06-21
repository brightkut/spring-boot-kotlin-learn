package com.example.demo.repo

import com.example.demo.model.CinemaSub
import org.springframework.data.jpa.repository.JpaRepository

interface CinemaSubRepo :JpaRepository<CinemaSub,String>