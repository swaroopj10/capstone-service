package com.tradewave.restservices;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradewave.business.Client;
import com.tradewave.business.ClientResponse;
import com.tradewave.integration.ClientDaoMyBatisImpl;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired
	private Logger logger;

	@Autowired
	ClientDaoMyBatisImpl dao;
	
	public int insertClient(Client client) {
		int rowCount = 0;
		try {
			rowCount = dao.insertClient(client);
		} catch (DuplicateKeyException e) {
			throw new PreferenceDatabaseException("Duplicate Client", e);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PreferenceDatabaseException("Cannot insert client", e);
		}
		return rowCount;
	}

	public int insertClientIdentification(Client client) {
		int rowCount = 0;
		try {
			rowCount = dao.insertClientIdentification(client);
		} catch (DuplicateKeyException e) {
			throw new PreferenceDatabaseException("Duplicate Client", e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PreferenceDatabaseException("Cannot insert client", e);
		}
		return rowCount;
	}
	
	public int insertClientToken(ClientResponse clientResponse) {
		int rowCount = 0;
		try {
			rowCount = dao.insertClientResponse(clientResponse);
		} catch (DuplicateKeyException e) {
			throw new PreferenceDatabaseException("Duplicate Client", e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PreferenceDatabaseException("Cannot insert client", e);
		}
		return rowCount;
	}

	@Override
	@Transactional
	public String register(Client client, ClientResponse clientResponse) throws SQLException {
		try {
			if(client!=null) {
				if(!checkEmailExists(client.getEmail())) {
					logger.error("Email already exists");
					throw new IllegalArgumentException("Email already exists");
				}
				insertClient(client);
				insertClientIdentification(client);
				insertClientToken(clientResponse);
				return "success";
			}
			else {
				throw new SQLException("DB ERROR");
			}

		}catch(SQLException e) {
			throw new SQLException("DB ERROR");
		}
	}

	Boolean checkEmailExists(String email)
	{
		return dao.getUserByEmail(email)==null;
	}
	
	@Override
	public String getUserByEmail(String clientId) {
		return dao.getUserByEmail(clientId);
	}

	@Override
	public String generateToken(String email) {
		return dao.getToken(email);
	}

	@Override
	public String getClientId(String clientId) {
		return dao.getClientId(clientId);
	}

}

