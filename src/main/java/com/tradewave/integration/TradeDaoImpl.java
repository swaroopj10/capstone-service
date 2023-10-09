package com.tradewave.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tradewave.business.Order;
import com.tradewave.business.Trade;
import com.tradewave.integration.mapper.TradeMapper;

@Repository("tradeDao")
public class TradeDaoImpl implements TradeDao {
	
	@Autowired
	private TradeMapper mapper;

	@Override
	public int createOrder(Order order) {
		int count = mapper.createOrder(order);
		return count;
	}

	@Override
	public int createTrade(Trade trade) {
		int count = mapper.createTrade(trade);
		return count;
	}

	@Override
	public List<Trade> getTradeHistory(String clientId) {
		List<Trade> tradeHistory = mapper.getTradeHistory(clientId);
		return tradeHistory;
	}

	@Override
	public List<Trade> getPortfolio(String clientId) {
		List<Trade> portfolio = mapper.getPortfolio(clientId);
		return portfolio;
	}

}
