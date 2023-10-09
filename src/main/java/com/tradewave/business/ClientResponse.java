package com.tradewave.business;

import java.util.Objects;

public class ClientResponse {
	
	private String clientId;
	private String email;
	private String token;
	
	public ClientResponse() {}
	
	public ClientResponse(String clientId, String email, String token) {
		this.clientId = clientId;
		this.email = email;
		this.token = token;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, email, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientResponse other = (ClientResponse) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(email, other.email)
				&& Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "ClientResponse [clientId=" + clientId + ", email=" + email + ", token=" + token + "]";
	}
	
}
