package me.chnu.enumdialect.annotation

import me.chnu.enumdialect.testcontainers.ContainerConfig
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(ContainerConfig::class)
annotation class Container

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Container
annotation class BaseIntegrationTest

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ActiveProfiles("mysql")
@BaseIntegrationTest
annotation class MysqlTest

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ActiveProfiles("postgres")
@BaseIntegrationTest
annotation class PostgresTest