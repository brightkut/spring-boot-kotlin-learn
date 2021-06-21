package com.example.demo.repo

import com.example.demo.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface MovieRepo : JpaRepository<Movie, String>{
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update Movie m set m.name = :name where m.id = :id")
    fun updateMovieName(id:String,name:String)
}
