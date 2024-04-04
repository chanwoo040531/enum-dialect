package me.chnu.enumdialect.domain.posting

import jakarta.persistence.*

@Entity
@Table(name = "postings")
class Posting(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    var title: String,

    var content: String,

    @Enumerated(EnumType.STRING)
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