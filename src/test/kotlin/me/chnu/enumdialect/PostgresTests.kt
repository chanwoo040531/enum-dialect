package me.chnu.enumdialect

import me.chnu.enumdialect.annotation.PostgresTest
import me.chnu.enumdialect.domain.posting.Posting
import me.chnu.enumdialect.domain.posting.PostingRepository
import me.chnu.enumdialect.domain.posting.PostingStatus
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.jdbc.Sql

@PostgresTest
@DisplayName("Postgres Tests")
class PostgresTests {
    @Autowired
    private lateinit var postingRepository: PostingRepository

    @Test
    @DisplayName("Load contexts")
    fun contextLoads() {
    }

    @Test
    @DisplayName("Insert a posting")
    fun createPosting() {
        postingRepository.save(Posting(title = "title", content = "content", status = PostingStatus.DRAFT))
    }

    @Test
    @DisplayName("Inquire a posting")
    fun getPosting() {
        postingRepository.findById(1)
    }

    @Test
    @DisplayName("Update a posting")
    fun updatePosting() {
        postingRepository.findByIdOrNull(1L)?.let {
            it.status = PostingStatus.PUBLISHED
            postingRepository.save(it)
        }
    }
}

