package com.tradewave.business;

import java.util.Objects;

public class Order {
  
	private String instrumentId;
    private double quantity;
    private double targetPrice;
    private String direction;
    private String clientId;
    private String orderId;
    private String email;
    private String token;

	public Order() {}
    
    public Order(String instrumentId, double quantity, double targetPrice, String direction, String clientId, String orderId, String email, String token) {
        this.instrumentId = instrumentId;
        this.quantity = quantity;
        this.targetPrice = targetPrice;
        this.direction = direction;
        this.clientId = clientId;
        this.orderId = orderId;
        this.email = email;
        this.token = token;
    }

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
		return Objects.hash(clientId, direction, email, instrumentId, orderId, quantity, targetPrice, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(direction, other.direction)
				&& Objects.equals(email, other.email) && Objects.equals(instrumentId, other.instrumentId)
				&& Objects.equals(orderId, other.orderId)
				&& Double.doubleToLongBits(quantity) == Double.doubleToLongBits(other.quantity)
				&& Double.doubleToLongBits(targetPrice) == Double.doubleToLongBits(other.targetPrice)
				&& Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "Order [instrumentId=" + instrumentId + ", quantity=" + quantity + ", targetPrice=" + targetPrice
				+ ", direction=" + direction + ", clientId=" + clientId + ", orderId=" + orderId + ", email=" + email
				+ ", token=" + token + "]";
	}
	
}

