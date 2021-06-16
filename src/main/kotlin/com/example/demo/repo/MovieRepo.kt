package com.example.demo.repo

import com.example.demo.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface MovieRepo : JpaRepository<Movie, String>
