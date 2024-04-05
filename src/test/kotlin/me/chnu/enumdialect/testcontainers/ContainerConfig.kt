package me.chnu.enumdialect.testcontainers

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.testcontainers.containers.JdbcDatabaseContainer
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
@ConditionalOnMissingBean(JdbcDatabaseContainer::class)
class ContainerConfig {

    @Bean
    @Profile("mysql")
    @ServiceConnection
    fun mysqlContainer(): MySQLContainer<*> =
        DockerImageName.parse("mysql/mysql-server:8.0.32").asCompatibleSubstituteFor("mysql")
            .let { image -> MySQLContainer(image) }
            .apply {
                withDatabaseName("testdb")
                withUsername("testuser")
                withPassword("testpass")
            }

    @Bean
    @Profile("postgres")
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> =
        PostgreSQLContainer("postgres:15.6-alpine3.19").apply {
            withDatabaseName("testdb")
            withUsername("testuser")
            withPassword("testpass")
        }
}