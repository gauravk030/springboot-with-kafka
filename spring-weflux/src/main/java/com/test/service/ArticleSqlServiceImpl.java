package com.test.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.test.model.ArticleSql;
import com.test.model.BaseArticle;
import com.test.repository.ArticleSqlRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
/*If you want to use sql, add @primary here*/
@Primary
@Qualifier("sqlService")
public class ArticleSqlServiceImpl implements ArticleService {
    private final ArticleSqlRepository repository;

    public ArticleSqlServiceImpl(ArticleSqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BaseArticle> saveArticle(BaseArticle article) {
        return repository.save((ArticleSql) article).map(a -> (BaseArticle) a);
    }

    @Override
    public Flux<BaseArticle> findAllArticles() {
        return repository.findAll().map(a -> (BaseArticle) a);
    }

    @Override
    public Mono<BaseArticle> findOneArticle(String id) {
        return repository.findById(id).map(a -> (BaseArticle) a);
    }

    @Override
    public Flux<BaseArticle> findByAuthor(String author) {
        return repository.findByAuthor(author).map(a -> (BaseArticle) a);
    }

    @Override
    public Mono<Void> deleteArticle(String id) {
        return repository.deleteById(id);
    }
}
