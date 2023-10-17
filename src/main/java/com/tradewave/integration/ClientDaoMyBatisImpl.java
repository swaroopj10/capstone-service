package com.tradewave.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tradewave.business.Client;
import com.tradewave.business.ClientResponse;
import com.tradewave.integration.mapper.ClientMapper;


@Repository("clientsDao")
@Primary
public class ClientDaoMyBatisImpl implements ClientDao{
	
	@Autowired
	private ClientMapper mapper;
	
	@Override
	@Transactional
	public int insertClient(Client client) {
		if(client==null) {
			throw new CustomException("Client can't be null");
		}
		return mapper.insertClient(client);

	}

	@Transactional
	public int insertClientIdentification(Client client) {
		if(client==null) {
			throw new CustomException("Client can't be null");
		}
		return mapper.insertClientIdentification(client);

	}

	@Override
	public int insertClientResponse(ClientResponse clientResponse) {
		return mapper.insertClientResponse(clientResponse);
	}

	@Override
	public String getUserByEmail(String email) {
		return mapper.getUserByEmail(email);
	}


	@Override
	public String getToken(String email) {
		return mapper.getToken(email);
	}

	@Override
	public String getClientId(String clientId) {
		return mapper.getClientId(clientId);
	}
}
