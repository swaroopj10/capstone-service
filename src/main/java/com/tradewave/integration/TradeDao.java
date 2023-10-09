package com.tradewave.integration;

import java.util.List;

import com.tradewave.business.Order;
import com.tradewave.business.Trade;

public interface TradeDao {
	int createOrder(Order order);

	int createTrade(Trade trade);

	List<Trade> getTradeHistory(String clientId);

	List<Trade> getPortfolio(String clientId);
}
