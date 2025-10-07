package com.test.service;

import com.test.model.BaseArticle;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArticleService {
    Mono<BaseArticle> saveArticle(BaseArticle article);
    Flux<BaseArticle> findAllArticles();
    Mono<BaseArticle> findOneArticle(String id);
    Flux<BaseArticle> findByAuthor(String author);
    Mono<Void> deleteArticle(String id);
}
