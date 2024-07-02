package com.example.multiple.mongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoPrimaryConfig {

    @Primary
    @Bean(name = "primaryDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.primary")
    public MongoProperties getPrimaryProperties(){
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "primaryMongoTemplate")
    public MongoTemplate primaryMongoTemplate (){
        return new MongoTemplate(primaryMongoDatabaseFactory(getPrimaryProperties()));
    }

    @Primary
    @Bean
    public MongoDatabaseFactory primaryMongoDatabaseFactory(MongoProperties mongoProperties){
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }

}
