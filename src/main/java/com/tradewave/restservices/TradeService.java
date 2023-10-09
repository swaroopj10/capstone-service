package com.tradewave.restservices;

import java.util.List;

import com.tradewave.business.Order;
import com.tradewave.business.Trade;

public interface TradeService {
	int createOrder(Order order);

	int createTrade(Trade trade);

	List<Trade> getTradeHistory(String clientId);

	List<Trade> getPortfolio(String clientId);
}
