package com.test.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ArticleMongo.class, name = "mongo"),
    @JsonSubTypes.Type(value = ArticleSql.class, name = "sql")
})
public interface BaseArticle {
    String getId(); // Use String for Mongo; for SQL, convert Long to String
    String getTitle();
    String getContent();
    String getAuthor();
    LocalDateTime getPublishedAt();
    
    void setTitle(String title);
    void setContent(String content);
    void setAuthor(String author);
    void setPublishedAt(LocalDateTime publishedAt);
}
