package com.acc.wcat.cosmosdbrest.config;


import com.microsoft.azure.spring.data.cosmosdb.CosmosDbFactory;
import com.microsoft.azure.spring.data.cosmosdb.config.AbstractCosmosConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.CosmosDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.core.CosmosOperations;
import com.microsoft.azure.spring.data.cosmosdb.core.CosmosTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties(CosmosDatabaseProperties.class)
public class CosmosConfiguration extends AbstractCosmosConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(CosmosConfiguration.class);

    @Autowired
    private CosmosDatabaseProperties cosmosDatabaseProperties;

    @Bean
    @Primary
    public CosmosDBConfig getConfig() {
        LOGGER.info("Creating CosmosDBConfig2, database key: [{}].", cosmosDatabaseProperties.getKey());
        return CosmosDBConfig.builder(cosmosDatabaseProperties.getUri(), cosmosDatabaseProperties.getKey(), cosmosDatabaseProperties.getDatabase()).build();
    }

   @Bean
    @Primary
    public CosmosDbFactory myDocumentDbFactory(CosmosDBConfig config) {
        LOGGER.info("Creating CosmosDbFactory with database key: [{}]", config.getKey());
        return new CosmosDbFactory(config);
    }

 /*   @Bean
    @Primary
    public ReactiveCosmosOperations reactiveCosmosOperations(CosmosDBConfig config) throws ClassNotFoundException {
        LOGGER.info("Creating CosmosDbFactory with database key333: [{}]", config.getKey());
        return new ReactiveCosmosTemplate(this.myDocumentDbFactory(config), this.mappingCosmosConverter(),
                config.getDatabase());
    }*/

    @Bean
    @Primary
    public CosmosOperations cosmosOperations(CosmosDBConfig config) throws ClassNotFoundException {
        LOGGER.info("Creating CosmosDbFactory with database key333: [{}]", config.getKey());
        return new CosmosTemplate(this.myDocumentDbFactory(config), this.mappingCosmosConverter(),
                config.getDatabase());
    }

}
