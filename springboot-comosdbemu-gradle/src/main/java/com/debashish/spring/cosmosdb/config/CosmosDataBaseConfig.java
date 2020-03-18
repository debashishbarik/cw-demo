package com.debashish.spring.cosmosdb.config;

import com.azure.data.cosmos.CosmosKeyCredential;
import com.debashish.spring.cosmosdb.repository.UserRepository;
import com.microsoft.azure.spring.data.cosmosdb.config.AbstractCosmosConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.CosmosDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableReactiveCosmosRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableReactiveCosmosRepositories(basePackageClasses = UserRepository.class)
@Slf4j
public class CosmosDataBaseConfig extends AbstractCosmosConfiguration {

    @Value("${azure.cosmosdb.uri}")
    private String uri;

    @Value("${azure.cosmosdb.key}")
    private String key;

    @Value("${azure.cosmosdb.database}")
    private String database;

    @Bean
    @Primary
    public CosmosDBConfig cosmosDbConfig() {
        CosmosKeyCredential cosmosKeyCredential = new CosmosKeyCredential(key);
        CosmosDBConfig cosmosDBConfig = CosmosDBConfig.builder(uri, cosmosKeyCredential,
                database).build();
        //  cosmosDBConfig.setPopulateQueryMetrics(properties.isPopulateQueryMetrics());
        //cosmosDBConfig.setResponseDiagnosticsProcessor(new ResponseDiagnosticsProcessorImplementation());
        return cosmosDBConfig;
    }
}
