package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferServices {

    private static final String API_BASE_URL = "http://localhost:8080/user/";

    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public void setAuthToken(String authToken){
        this.authToken = authToken;
    }

    public boolean sendBucks(Transfer transferFrom)//long toMemberId, BigDecimal amountToSend)
    {

        boolean success = false;
        try {
//            restTemplate.put(API_BASE_URL, HttpMethod.PUT, makeAuthEntity());
//            }

            String url = API_BASE_URL + transferFrom.getFromUserId();
            HttpEntity<Transfer> entity = makeTransferEntity(transferFrom);

            restTemplate.put(url, entity);
            success = true;
        }
        catch (RestClientResponseException e)
        {

        }
        return success;
    }
    public boolean receiveBucks(Transfer transferTo)
    {
        boolean success = false;
        try {
            String url = API_BASE_URL + transferTo.getToUserId();
            HttpEntity<Transfer> entity = makeTransferEntity(transferTo);

            restTemplate.put(url, entity);
            success = true;
        } catch (RestClientResponseException e) {

        }
        return success;
    }
    
        private HttpEntity<Transfer> makeTransferEntity(Transfer transfer)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(authToken);
            return new HttpEntity<>(transfer, headers);
        }
//
//    private HttpEntity<Void> makeAuthEntity()
//    {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//    }
}
