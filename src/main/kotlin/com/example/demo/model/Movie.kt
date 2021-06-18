package com.example.demo.model

import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.Size

@Entity
@Table
data class Movie(
        @Id
        @Column(name = "id")
        val id: String?,
        @Column(name = "name")
        @field:Size(min=1,max=5)
        val name: String,
        @Column(name = "des")
        val des: String,
        @Column(name = "price")
        @field:Max(value = 100)
        val price: Int
)
