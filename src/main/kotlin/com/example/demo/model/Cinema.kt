package com.example.demo.model

import javax.persistence.*

@Entity
@Table
@IdClass(CinemaCompositePkey::class)
data class Cinema(
        @Id
        @Column(name = "cinemaId")
        val cinemaId: String,
        @Id
        @Column(name = "cinemaSubId")
        val cinemaSubId: String,
        // can use option nullable true and false
        // not need to set nullable true you can set default null and optional field
        // can unique option
        @Column(name = "cinemaName",unique = true)
        val cinemaName: String? = null,
        //if need mandatory add nullable false
        @Column(name = "price",nullable = false)
        val price: Int
)
