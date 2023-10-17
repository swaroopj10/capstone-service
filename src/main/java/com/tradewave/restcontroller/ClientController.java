package com.tradewave.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradewave.business.Client;
import com.tradewave.business.ClientAuth;
import com.tradewave.business.ClientResponse;
import com.tradewave.business.Credentials;
import com.tradewave.restservices.ClientServiceImpl;

@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientServiceImpl service;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private ObjectMapper objectMapper; 
	
	@PostMapping("/register")
	public ResponseEntity<String> createTask(@RequestBody Client client) throws SQLException {
		ClientAuth clientAuth = new ClientAuth();
        clientAuth.setClientId(client.getClientId());
        clientAuth.setEmail(client.getEmail());
        
        try {
        	HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<ClientAuth> requestEntity = new HttpEntity<>(clientAuth, headers);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                    "http://localhost:3000/fmts/client",
                    requestEntity,
                    String.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                String responseBody = responseEntity.getBody();
                ClientResponse clientResponse = objectMapper.readValue(responseBody, ClientResponse.class);
                if (clientResponse != null) {
                	client.setClientId(clientResponse.getClientId());
//                    service.insertClient(client);
//                    service.insertClientIdentification(client);
//                    service.insertClientToken(clientResponse);
                    service.register(client, clientResponse);
                    return ResponseEntity.ok(responseBody); 
                }
            }

            return ResponseEntity.badRequest().body(null); 
        } catch (HttpClientErrorException e) {
            HttpStatus statusCode = e.getStatusCode();
            String errorMessage = "Error from /fmts/client: " + statusCode.getReasonPhrase();
            return ResponseEntity.status(statusCode).body(errorMessage); 
        } catch (Exception e) {
            String errorMessage = "Internal server error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage); 
        }
    }


	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Credentials credentials) {
        try {
        	String clientId = service.getClientId(credentials.getClientId());
            if (clientId == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client ID does not exist.");
            }
            
            String email = service.getUserByEmail(credentials.getEmail());
            if (email == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email does not exist.");
            } else {
            	email = credentials.getEmail();
            }

            String token = service.generateToken(email);

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
