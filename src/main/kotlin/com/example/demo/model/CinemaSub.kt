package com.example.demo.model

import javax.persistence.*

@Entity
@Table
data class CinemaSub(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "csId")
        val csId: Int = 0,

        @Column(name= "cinemaSubName")
        val cinemaSubName: String,

//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumns(
//                JoinColumn(name = "cinemaId",referencedColumnName = "cinemaId"),
//                JoinColumn(name = "cinemaSubId", referencedColumnName = "cinemaSubId")
//        )
//        val  cinema: Cinema? = null
)
