package com.tradewave.business;

import java.util.Objects;

public class Client {
	private String clientId; 
	private String email;
	private String dateOfBirth;
	private String country;
	private String postalCode;
	private ClientIdentification clientIdentification;

	public Client(){}

	public Client(String clientId, String email, String dateOfBirth, String country, String postalCode,
			ClientIdentification clientIdentification) {
		super();
		this.clientId = clientId;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.postalCode = postalCode;
		this.clientIdentification = clientIdentification;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public ClientIdentification getClientIdentification() {
		return clientIdentification;
	}

	public void setClientIdentification(ClientIdentification clientIdentification) {
		this.clientIdentification = clientIdentification;
	}
	@Override
	public int hashCode() {
		return Objects.hash(clientId, clientIdentification, country, dateOfBirth, email, postalCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(clientId, other.clientId)
				&& Objects.equals(clientIdentification, other.clientIdentification)
				&& Objects.equals(country, other.country) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(email, other.email) 
				&& Objects.equals(postalCode, other.postalCode);
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", country=" + country + ", postalCode=" + postalCode + ", clientIdentification="
				+ clientIdentification + "]";
	}
}
