package com.tradewave.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tradewave.business.Order;
import com.tradewave.business.Trade;

@Mapper
public interface TradeMapper {
	int createOrder(Order order);

	int createTrade(Trade trade);

	List<Trade> getTradeHistory(String clientId);

	List<Trade> getPortfolio(String clientId);
}
