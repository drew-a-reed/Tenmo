package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class UserServices
{

    private static final String API_BASE_URL = "http://localhost:8080/user/";

    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public User[] listUsers(){
        User[] users = null;

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(authToken);
            HttpEntity<Void> entity = new HttpEntity<>(headers);
            ResponseEntity<User[]> response = restTemplate.exchange(API_BASE_URL, HttpMethod.GET, makeAuthEntity(), User[].class);
            users =(response.getBody());
        }
        catch(RestClientResponseException e){

        }
        return users;
    }

    private HttpEntity<Void> makeAuthEntity()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
