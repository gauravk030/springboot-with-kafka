## In this Webflux service I am using two databases(SQL and Mongo)
#### Note 
	- JPA does not suppport reactive WebFlux
   
#For clean and build the project - (if needed)
	- mvn dependency:purge-local-repository
	- mvn clean install

# Create table

CREATE TABLE articles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(255),
    published_at TIMESTAMP NOT NULL
);

# Save Artical 
http://localhost:8080/api/articles/save

### For SQL
CREATE TABLE articles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(255),
    published_at TIMESTAMP NOT NULL
);
payload =:
{
  "type": "sql",
  "id": "101",
  "title": "Spring R2DBC",
  "author": "Gaurav",
  "content": "Using MySQL",
  "publishedAt": "2025-10-07T22:45:00"
}

### For Mongo
payload =:
{
  "type": "mongo",
  "id": "101",
  "title": "Spring WebFlux",
  "author": "Gaurav",
  "content": "Using Mongo",
  "publishedAt": "2025-10-07T22:45:00"
}

# Get article by Id
http://localhost:8080/api/articles/101