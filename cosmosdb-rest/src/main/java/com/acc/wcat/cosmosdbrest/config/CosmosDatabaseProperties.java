package com.acc.wcat.cosmosdbrest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ConfigurationProperties(prefix = "azure.cosmosdb")
@Component
public class CosmosDatabaseProperties {

    private String uri;

    private String key;

    private String database;
}
