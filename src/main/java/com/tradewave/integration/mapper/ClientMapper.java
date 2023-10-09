package com.tradewave.integration.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tradewave.business.Client;
import com.tradewave.business.ClientResponse;


@Mapper
public interface ClientMapper {
	int insertClient(Client client);
	int insertClientIdentification(Client client);
	int insertClientResponse(ClientResponse clientResponse);
	String getUserByEmail(String clientId);
	String getToken(String clientId);
	String getClientId(String clientId);
}
