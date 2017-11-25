package com.newssystem.server.NewsSystem.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.newssystem.server.NewsSystem.repository")
public class DateBaseConfiguration extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.password}")
    private String password;


    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(host + ":" + port);
    }
}
