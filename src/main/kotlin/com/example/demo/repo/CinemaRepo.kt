package com.example.demo.repo

import com.example.demo.model.Cinema
import com.example.demo.model.CinemaCompositePkey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface CinemaRepo:JpaRepository<Cinema,CinemaCompositePkey>