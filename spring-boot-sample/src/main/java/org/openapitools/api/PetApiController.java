package org.openapitools.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.model.Pet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-09T00:22:19.250+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.openAPIPetstore.base-path:/v2}")
public class PetApiController implements PetApi {

    private final NativeWebRequest request;

    @Value("classpath:data/response.json")
    Resource resourceFile;

    @org.springframework.beans.factory.annotation.Autowired
    public PetApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) throws IOException {
        File petFile = resourceFile.getFile();
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = mapper.readValue(petFile, Pet.class);
        pet.setId(petId);
        return ResponseEntity.ok(pet);
    }

}
