package me.chnu.enumdialect.domain.posting

import org.springframework.data.jpa.repository.JpaRepository


interface PostingRepository : JpaRepository<Posting, Long>