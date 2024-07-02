package com.example.multiple.mongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoSecondaryConfig {

    @Bean(name = "secondaryDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.secondary")
    public MongoProperties getSecondaryProperties() {
        return new MongoProperties();
    }

    @Bean(name = "secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate() {
        return new MongoTemplate(secondaryMongoDatabaseFactory(getSecondaryProperties()));
    }

    @Bean
    public MongoDatabaseFactory secondaryMongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

}
