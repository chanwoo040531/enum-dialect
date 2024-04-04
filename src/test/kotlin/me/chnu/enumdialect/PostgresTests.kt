package me.chnu.enumdialect

import me.chnu.enumdialect.annotation.PostgresTest
import me.chnu.enumdialect.domain.posting.Posting
import me.chnu.enumdialect.domain.posting.PostingRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@PostgresTest
class PostgresTests {
    @Autowired
    private lateinit var postingRepository: PostingRepository

    @Test
    @DisplayName("Context loads successfully for Postgres")
    fun contextLoads() {
    }

    @Test
    @DisplayName("Create posting for Postgres")
    fun createPosting() {
        postingRepository.save(Posting.INSTANCE)
    }
}

