package com.example.demo

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories
class Config {

    @Bean
    fun dataSource(env: Environment): DataSource {

        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/movieDB?useUnicode=true&characterEncoding=UTF-8")
        dataSourceBuilder.username("root")
        dataSourceBuilder.password("password")
        return dataSourceBuilder.build()

    }
}