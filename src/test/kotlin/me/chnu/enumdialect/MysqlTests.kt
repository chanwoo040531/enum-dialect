package me.chnu.enumdialect

import me.chnu.enumdialect.annotation.MysqlTest
import me.chnu.enumdialect.domain.posting.Posting
import me.chnu.enumdialect.domain.posting.PostingRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@MysqlTest
class MysqlTests {
    @Autowired
    private lateinit var postingRepository: PostingRepository

    @Test
    @DisplayName("Context loads successfully for Mysql")
    fun contextLoads() {
    }

    @Test
    @DisplayName("Create posting for Mysql")
    fun createPosting() {
        postingRepository.save(Posting.INSTANCE)
    }
}