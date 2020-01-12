package com.rest.client.restclienttest.controller;

import com.rest.client.restclienttest.model.Pet;
import com.rest.client.restclienttest.service.PetApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class HelloController {


    PetApiClientService petApiClientService;
    public HelloController(PetApiClientService petApiClientService) {
        this.petApiClientService = petApiClientService;
    }

    @RequestMapping("/pet/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable("petId") Long petId) {
        Pet response = petApiClientService.getPetByIdWithHttpInfo(petId);
        return ResponseEntity.ok(response);
    }
}
