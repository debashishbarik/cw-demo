package com.rest.client.restclienttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.client.restclienttest.model.Pet;
import com.rest.client.restclienttest.service.PetApiClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest
@DisplayName("Spring boot 2 mockito2 Junit5 example")
class RestClientTestApplicationTests {

    @Test
    void contextLoads() {

        System.out.println(resourceFile.getFilename());
    }

    @Value("classpath:data/response.json")
    Resource resourceFile;

    @Autowired
    private PetApiClientService empService;
    @Autowired
    private  RestTemplate restTemplateNew;

    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.bindTo(restTemplateNew)
				.ignoreExpectOrder(true)
				.bufferContent()
				.build();
    }

    @Test
    public void getPetById() throws URISyntaxException, IOException {
        File petFile = resourceFile.getFile();
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = mapper.readValue(petFile, Pet.class);
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://localhost:8080/v2/pet/1345")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(pet))
                );

        Pet petNew = empService.getPetByIdWithHttpInfo(1345L);
		mockServer.verify();
		assertEquals(pet.getName(), petNew.getName());
    }
}
