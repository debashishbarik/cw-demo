package com.example.cosmosdb;

import com.example.cosmosdb.domain.User;
import com.example.cosmosdb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

@SpringBootApplication
public class SpringbootCosmosdbApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootCosmosdbApplication.class);

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCosmosdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final User testUser = new User("1", "Tasha", "Calderon", "4567 Main St Buffalo, NY 98052");

		LOGGER.info("Saving user: {}", testUser);

		// Save the User class to Azure CosmosDB database.
		final Mono<User> saveUserMono = userRepository.save(testUser);

		final Flux<User> firstNameUserFlux = userRepository.findByFirstName("testFirstName");

		//  Nothing happens until we subscribe to these Monos.
		//  findById will not return the user as user is not present.
		final Mono<User> findByIdMono = userRepository.findById(testUser.getId());
		final User findByIdUser = findByIdMono.block();
		Assert.isNull(findByIdUser, "User must be null");

		final User savedUser = saveUserMono.block();
		Assert.state(savedUser != null, "Saved user must not be null");
		Assert.state(savedUser.getFirstName().equals(testUser.getFirstName()), "Saved user first name doesn't match");

		LOGGER.info("Saved user");

		firstNameUserFlux.collectList().block();

		final Optional<User> optionalUserResult = userRepository.findById(testUser.getId()).blockOptional();
		Assert.isTrue(optionalUserResult.isPresent(), "Cannot find user.");

		final User result = optionalUserResult.get();
		Assert.state(result.getFirstName().equals(testUser.getFirstName()), "query result firstName doesn't match!");
		Assert.state(result.getLastName().equals(testUser.getLastName()), "query result lastName doesn't match!");

		LOGGER.info("Found user by findById : {}", result);
	}

	@PostConstruct
	public void setup() {
		final User user_1 = new User("2", "Tasha", "Calderon", "4567 Main St Buffalo, NY 98052");
		LOGGER.info("Creating user in the database");
		this.userRepository.save(user_1);
		LOGGER.info("Saved");
		//this.userRepository.deleteAll().block();
	}

	@PreDestroy
	public void cleanup() {
		LOGGER.info("Cleaning up users");
		this.userRepository.deleteAll().block();
	}
}
