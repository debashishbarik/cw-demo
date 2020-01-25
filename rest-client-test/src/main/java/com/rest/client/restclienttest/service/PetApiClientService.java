package com.rest.client.restclienttest.service;

import com.rest.client.restclienttest.model.Pet;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PetApiClientService {

    private ApiClient apiClient;

    public PetApiClientService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Pet getPetByIdWithHttpInfo(Long petId) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'petId' is set
        if (petId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'petId' when calling getPetById");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("petId", petId);
        String path = apiClient.expandPath("/pet/{petId}", uriVariables);
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final String[] accepts = { "application/json"};
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);
        ParameterizedTypeReference<Pet> returnType = new ParameterizedTypeReference<Pet>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, accept, contentType, returnType).getBody();
    }
}
