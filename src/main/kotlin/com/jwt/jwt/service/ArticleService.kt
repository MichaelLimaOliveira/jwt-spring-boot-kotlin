package com.jwt.jwt.service

import com.jwt.jwt.model.Article
import com.jwt.jwt.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService (
    private val articleRepository: ArticleRepository
) {

    fun findAll(): List<Article> = articleRepository.findAll()

}