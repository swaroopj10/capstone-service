package com.tradewave.integration;

import com.tradewave.business.Client;
import com.tradewave.business.ClientResponse;

public interface ClientDao {
	int insertClient(Client client);
	int insertClientIdentification(Client client);
	int insertClientResponse(ClientResponse clientResponse);
	String getUserByEmail(String clientId);
	String getToken(String email);
	String getClientId(String clientId);
}
