package com.test.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.test.model.ArticleMongo;
import reactor.core.publisher.Flux;

public interface ArticleMongoRepository extends ReactiveMongoRepository<ArticleMongo, String> {
	@Query("{'author': ?0}")
	Flux<ArticleMongo> findByAuthor(String author);
}