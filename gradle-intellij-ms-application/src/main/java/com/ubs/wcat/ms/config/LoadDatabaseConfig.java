package com.ubs.wcat.ms.config;

import com.ubs.wcat.ms.domain.EmployeeEntity;
import com.ubs.wcat.ms.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot will run ALL CommandLineRunner beans once the application context is loaded
 */
@Configuration
@Slf4j
public class LoadDatabaseConfig {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.debug("Preloading " + repository.save(new EmployeeEntity("Peter Park", "User")));
            log.debug("Preloading " + repository.save(new EmployeeEntity("Tony Stark", "Admin")));
        };
    }

}
