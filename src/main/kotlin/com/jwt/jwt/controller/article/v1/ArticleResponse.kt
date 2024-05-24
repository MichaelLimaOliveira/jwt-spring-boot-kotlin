package com.jwt.jwt.controller.article.v1

import java.util.*

data class ArticleResponse(
    val id: UUID,
    val title: String,
    val content: String,
)
