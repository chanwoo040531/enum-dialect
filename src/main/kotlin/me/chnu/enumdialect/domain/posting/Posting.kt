package me.chnu.enumdialect.domain.posting

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "postings")
class Posting(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    var title: String,

    var content: String,

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    var status: PostingStatus,
) {
    companion object {
        val INSTANCE: Posting = Posting(
            title = "title",
            content = "content",
            status = PostingStatus.DRAFT,
        )
    }
}