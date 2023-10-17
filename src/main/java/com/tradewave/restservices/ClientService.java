package com.tradewave.restservices;

import java.sql.SQLException;

import com.tradewave.business.Client;
import com.tradewave.business.ClientResponse;

public interface ClientService {
	int register(Client client, ClientResponse clientResponse) throws SQLException;
	String getUserByEmail(String clientId);
	String generateToken(String email);
	String getClientId(String clientId);
}
