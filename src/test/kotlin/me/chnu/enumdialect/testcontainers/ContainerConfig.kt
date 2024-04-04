package me.chnu.enumdialect.testcontainers

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.testcontainers.containers.JdbcDatabaseContainer
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
@ConditionalOnMissingBean(JdbcDatabaseContainer::class)
class ContainerConfig {

    @Bean
    @Profile("mysql")
    @ServiceConnection
    fun mysqlContainer(): MySQLContainer<*> =
        MySQLContainer(DockerImageName.parse("mysql:8.0.24"))

    private val postgisImage: DockerImageName = DockerImageName.parse("postgis/postgis:15-3.4")
        .asCompatibleSubstituteFor("postgres")

    @Bean
    @Profile("postgres")
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> =
        PostgreSQLContainer(postgisImage)
}