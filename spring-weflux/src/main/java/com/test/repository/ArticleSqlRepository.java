package com.test.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.test.model.ArticleSql;
import reactor.core.publisher.Flux;

/*JPA data not support reactive webflux*/
@Repository
public interface ArticleSqlRepository extends ReactiveCrudRepository<ArticleSql, String> {
   Flux<ArticleSql> findByAuthor(String author);
}