package com.rest.client.restclienttest.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class ApiClient {
    private static final String basePath = "http://localhost:8080/v2/";
    RestTemplate restTemplateNew;

    public ApiClient(RestTemplate restTemplateNew) {
        this.restTemplateNew = restTemplateNew;
    }

    /**
     * Invoke API by sending HTTP request with the given options.
     *
     * @param <T>          the return type to use
     * @param path         The sub-path of the HTTP URL
     * @param method       The request method
     * @param queryParams  The query parameters
     * @param body         The request body object
     * @param accept       The request's Accept header
     * @param contentType  The request's Content-Type header
     * @param returnType   The return type into which to deserialize the response
     * @return ResponseEntity&lt;T&gt; The response of the chosen type
     */
    public <T> ResponseEntity<T> invokeAPI(String path, HttpMethod method, MultiValueMap<String, String> queryParams, Object body, List<MediaType> accept, MediaType contentType, ParameterizedTypeReference<T> returnType) throws RestClientException {

        URI uri = uriBuilder(path, queryParams);
        RequestEntity<Object> requestEntity = requestEntityBuilder(method, body, accept, contentType, uri);
        ResponseEntity<T> responseEntity = restTemplateNew.exchange(requestEntity, returnType);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("---------->"+returnType.getType().toString());
            return responseEntity;
        } else {
            // The error handler built into the RestTemplate should handle 400 and 500 series errors.
            throw new RestClientException("API returned " + responseEntity.getStatusCode() + " and it wasn't handled by the RestTemplate error handler");
        }
    }

    private URI uriBuilder(String path, MultiValueMap<String, String> queryParams) {
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(basePath).path(path);
        if (queryParams != null) {
            //encode the query parameters in case they contain unsafe characters
            for (List<String> values : queryParams.values()) {
                if (values != null) {
                    for (int i = 0; i < values.size(); i++) {
                        try {
                            values.set(i, URLEncoder.encode(values.get(i), "utf8"));
                        } catch (UnsupportedEncodingException e) {

                        }
                    }
                }
            }
            builder.queryParams(queryParams);
        }

        URI uri;
        try {
            uri = new URI(builder.build().toUriString());
        } catch (URISyntaxException ex) {
            throw new RestClientException("Could not build URL: " + builder.toUriString(), ex);
        }
        return uri;
    }

    private RequestEntity<Object> requestEntityBuilder(HttpMethod method, Object body, List<MediaType> accept, MediaType contentType, URI uri) {
        final RequestEntity.BodyBuilder requestBuilder = RequestEntity.method(method, uri);
        if (accept != null) {
            requestBuilder.accept(accept.toArray(new MediaType[accept.size()]));
        }
        if (contentType != null) {
            requestBuilder.contentType(contentType);
        }

        return requestBuilder.body(body);
    }

    /**
     * Expand path template with variables
     * @param pathTemplate path template with placeholders
     * @param variables variables to replace
     * @return path with placeholders replaced by variables
     */
    public String expandPath(String pathTemplate, Map<String, Object> variables) {
        return restTemplateNew.getUriTemplateHandler().expand(pathTemplate, variables).toString();
    }
    /**
     * Check if the given MIME is a JSON MIME.
     * JSON MIME examples:
     *     application/json
     *     application/json; charset=UTF8
     *     APPLICATION/JSON
     * @param mediaType the input MediaType
     * @return boolean true if the MediaType represents JSON, false otherwise
     */
    public boolean isJsonMime(MediaType mediaType) {
        return mediaType != null && (MediaType.APPLICATION_JSON.isCompatibleWith(mediaType) || mediaType.getSubtype().matches("^.*\\+json[;]?\\s*$"));
    }

    /**
     * Select the Accept header's value from the given accepts array:
     *     if JSON exists in the given array, use it;
     *     otherwise use all of them (joining into a string)
     *
     * @param accepts The accepts array to select from
     * @return List The list of MediaTypes to use for the Accept header
     */
    public List<MediaType> selectHeaderAccept(String[] accepts) {
        if (accepts.length == 0) {
            return null;
        }
        for (String accept : accepts) {
            MediaType mediaType = MediaType.parseMediaType(accept);
            if (isJsonMime(mediaType)) {
                return Collections.singletonList(mediaType);
            }
        }
        return MediaType.parseMediaTypes(StringUtils.arrayToCommaDelimitedString(accepts));
    }

    /**
     * Select the Content-Type header's value from the given array:
     *     if JSON exists in the given array, use it;
     *     otherwise use the first one of the array.
     *
     * @param contentTypes The Content-Type array to select from
     * @return MediaType The Content-Type header to use. If the given array is empty, JSON will be used.
     */
    public MediaType selectHeaderContentType(String[] contentTypes) {
        if (contentTypes.length == 0) {
            return MediaType.APPLICATION_JSON;
        }
        for (String contentType : contentTypes) {
            MediaType mediaType = MediaType.parseMediaType(contentType);
            if (isJsonMime(mediaType)) {
                return mediaType;
            }
        }
        return MediaType.parseMediaType(contentTypes[0]);
    }

}
