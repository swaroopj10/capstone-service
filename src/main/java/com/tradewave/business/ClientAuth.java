package com.tradewave.business;

import java.util.Objects;

public class ClientAuth {
	
	private String clientId;
	private String email;
	
	public ClientAuth() {}
	
	public ClientAuth(String clientId, String email) {
		this.clientId = clientId;
		this.email = email;
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

	@Override
	public int hashCode() {
		return Objects.hash(clientId, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientAuth other = (ClientAuth) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "ClientAuth [clientId=" + clientId + ", email=" + email + "]";
	}

}
