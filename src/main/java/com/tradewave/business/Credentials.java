package com.tradewave.business;

import java.util.Objects;

public class Credentials {
	private String email;
	private String clientId;
	
	public Credentials() {}
	
	public Credentials(String email, String clientId) {
		this.email = email;
		this.clientId = clientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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
		Credentials other = (Credentials) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "Credentials [email=" + email + ", clientId=" + clientId + "]";
	}

}
