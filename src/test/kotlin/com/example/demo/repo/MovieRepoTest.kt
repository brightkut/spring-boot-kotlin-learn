package com.example.demo.repo

import com.example.demo.model.Movie
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepoTest(@Autowired val entityManager: TestEntityManager, @Autowired val movieRepo: MovieRepo){

//    @Test
//    fun `when find all movie`() {
//        val movie = Movie("movie123", "sao", "anime", 20)
//        entityManager.persist(movie)
//        entityManager.flush()
//
//        val actual = movieRepo.findAll()
//
//        assertThat(actual[0]).isEqualTo(movie)
//        assertThat(actual.size).isEqualTo(1)
//
//        movieRepo.delete(movie)
//    }
//
//    @Test
//    fun `when save movie`(){
//        val movie = Movie("movie1234", "sao2", "anime", 40)
//
//        movieRepo.save(movie)
//
//        val actual = movieRepo.findAll()
//        assertThat(actual[0]).isEqualTo(movie)
//        assertThat(actual.size).isEqualTo(1)
//    }

    @Test
    fun `test intregation db`(){
        val movie = Movie("movie3", "iron", "action", 10)

        movieRepo.save(movie)

        val actual = movieRepo.findAll()

        assertThat(actual[0]).isEqualTo(movie)
        assertThat(actual.size).isEqualTo(1)
    }
}