package com.immutestable.dvdrental.infrastructure


import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.core.MongoTemplate

class TestMongoConfig extends AbstractMongoClientConfiguration { // TODO clean this up. Probably most of this is not needed

    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "test");
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    Collection getMappingBasePackages() {
        return Collections.singleton("com.immutestable");
    }
}