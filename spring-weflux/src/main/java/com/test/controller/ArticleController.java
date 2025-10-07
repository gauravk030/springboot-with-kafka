package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.BaseArticle;
import com.test.service.ArticleService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

	private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public Flux<BaseArticle> getAllArticles() {
        return articleService.findAllArticles();
    }

    @PostMapping("/save")
    public Mono<BaseArticle> createArticle(@RequestBody BaseArticle article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/get/{id}")
    public Mono<BaseArticle> getArticleById(@PathVariable String id) {
        return articleService.findOneArticle(id);
    }

    @GetMapping("/get/author/{author}")
    public Flux<BaseArticle> getArticlesByAuthor(@PathVariable String author) {
        return articleService.findByAuthor(author);
    }

    @PutMapping("/update/{id}")
    public Mono<BaseArticle> updateArticle(@PathVariable String id,
                                           @RequestBody BaseArticle article) {
        return articleService.findOneArticle(id)
                .flatMap(existing -> {
                    existing.setTitle(article.getTitle());
                    existing.setContent(article.getContent());
                    existing.setAuthor(article.getAuthor());
                    existing.setPublishedAt(article.getPublishedAt());
                    return articleService.saveArticle(existing);
                });
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteArticle(@PathVariable String id) {
        return articleService.deleteArticle(id);
    }
}