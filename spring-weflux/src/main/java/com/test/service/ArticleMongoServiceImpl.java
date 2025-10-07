package com.test.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.test.model.ArticleMongo;
import com.test.model.BaseArticle;
import com.test.repository.ArticleMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
/*If you want to use mongo, add @primary here*/
//@Primary
@Qualifier("mongoService")
public class ArticleMongoServiceImpl implements ArticleService {
    private final ArticleMongoRepository repository;

    public ArticleMongoServiceImpl(ArticleMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BaseArticle> saveArticle(BaseArticle article) {
        return repository.save((ArticleMongo) article).cast(BaseArticle.class);
    }

    @Override
    public Flux<BaseArticle> findAllArticles() {
        return repository.findAll().cast(BaseArticle.class);
    }

    @Override
    public Mono<BaseArticle> findOneArticle(String id) {
        return repository.findById(id).cast(BaseArticle.class);
    }

    @Override
    public Flux<BaseArticle> findByAuthor(String author) {
        return repository.findByAuthor(author).cast(BaseArticle.class);
    }

    @Override
    public Mono<Void> deleteArticle(String id) {
        return repository.deleteById(id);
    }
}