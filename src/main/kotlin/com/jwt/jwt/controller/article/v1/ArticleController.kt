package com.jwt.jwt.controller.article.v1

import com.jwt.jwt.model.Article
import com.jwt.jwt.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/article")
class ArticleController(private  val articleService: ArticleService) {

    private fun Article.toResponse(): ArticleResponse =
        ArticleResponse(
            id = this.id,
            title = this.title,
            content = this.content
        )

    @GetMapping
    fun listAll(): List<ArticleResponse> = articleService.findAll().map { it.toResponse() }


}