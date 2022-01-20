package com.test.rewards.config;

import java.util.Collection;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private static final Logger LOGGER = LogManager.getLogger(AbstractMongoClientConfiguration.class.getName());

    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        LOGGER.debug("retrieving database name");
        return env.getProperty("databaseName");
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(env.getProperty("mongoDBUri"));
        LOGGER.debug("retrieved databse connection string successfully");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                .build();
        LOGGER.debug("creating MongoClients Object");
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        LOGGER.debug("retrieving Base Packages for MongoDB");
        return Collections.singleton(env.getProperty("MappingBasePackages"));
    }
}
