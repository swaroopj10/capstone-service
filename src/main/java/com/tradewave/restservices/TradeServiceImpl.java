package com.tradewave.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradewave.business.Order;
import com.tradewave.business.Trade;
import com.tradewave.integration.TradeDao;
import com.tradewave.restcontroller.TradeException;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeDao dao;
	
	@Override
	public int createOrder(Order order) {
		int count = 0;
		try {
			count = dao.createOrder(order);
		} catch (DuplicateKeyException e) {
			throw new TradeException("Cannot insert duplicate order", e);
		} catch (RuntimeException e) {
			throw new TradeException("Error adding order", e);
		} catch (Exception e) {
			throw new TradeException("Error adding order", e);
		}
		return count;
	}

	@Override
	public int createTrade(Trade trade) {
		int count = 0;
		try {
			count = dao.createTrade(trade);
		} catch (DuplicateKeyException e) {
			throw new TradeException("Cannot insert duplicate trades", e);
		} catch (RuntimeException e) {
			throw new TradeException("Error adding trade", e);
		} catch (Exception e) {
			throw new TradeException("Error adding trade", e);
		}
		return count;
	}

	@Override
	public List<Trade> getTradeHistory(String clientId) {
		List<Trade> tradeHistory;
		try {
			tradeHistory = dao.getTradeHistory(clientId);
		} catch (Exception e) {
			throw new TradeException("Cannot get Trade History", e);
		}
		return tradeHistory;
	}

	@Override
	public List<Trade> getPortfolio(String clientId) {
		List<Trade> trades;
		List<Trade> portfolio = new ArrayList<>();
		try {
			trades = dao.getPortfolio(clientId);
			for(Trade trade : trades) {
				if (trade.getDirection().equals("B")) {
					boolean tradeExists = false;
	                for (Trade holding : portfolio) {
	                    if (holding.getInstrumentId().equals(trade.getInstrumentId())) {
	                        double newQuantity = holding.getQuantity() + trade.getQuantity();
	                        holding.setQuantity(newQuantity);
	                        tradeExists = true;
	                        break;
	                    }
	                }
	                if (!tradeExists) {
	                    portfolio.add(trade);
	                }
				} else if (trade.getDirection().equals("S")) {
					for (Trade holding : portfolio) {
						if (holding.getInstrumentId().equals(trade.getInstrumentId())) {
							double newQuantity = holding.getQuantity() - trade.getQuantity();
							if (newQuantity > 0) {
								holding.setQuantity(newQuantity);
							} else {
								portfolio.remove(holding);
							}
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new TradeException("Cannot get Trade History", e);
		}
		return portfolio;
	}

}
