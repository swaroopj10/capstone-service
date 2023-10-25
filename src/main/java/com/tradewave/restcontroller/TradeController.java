package com.tradewave.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradewave.business.Instrument;
import com.tradewave.business.InvestmentPreference;
import com.tradewave.business.Order;
import com.tradewave.business.Price;
import com.tradewave.business.RiskTolerance;
import com.tradewave.business.Trade;
import com.tradewave.restservices.PreferenceService;
import com.tradewave.restservices.TradeService;

@RestController
@RequestMapping("/api")
public class TradeController {
	private final String nodeServiceBaseUrl = "https://a745151.roifmr.com/fmts/trades";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper; 
    
    @Autowired
    private TradeService tradeService;
    
    @Autowired
	private PreferenceService preferenceService;

    @GetMapping("/prices")
    public ResponseEntity<Price[]> getPrices(@RequestParam(required=false, defaultValue="")String categoryId) {
        String pricesUrl = nodeServiceBaseUrl + "/prices";
        if (categoryId != null) {
            pricesUrl += "/" + categoryId;
        }
        ResponseEntity<String> response = restTemplate.getForEntity(pricesUrl, String.class);

        try {
            Price[] prices = objectMapper.readValue(response.getBody(), Price[].class);
            return ResponseEntity.ok(prices);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/instruments")
    public ResponseEntity<Instrument[]> getInstruments(@RequestParam(required=false, defaultValue="") String categoryId) {
        String instrumentsUrl = nodeServiceBaseUrl + "/instruments";
        if (categoryId != null) {
            instrumentsUrl += "/" + categoryId;
        }
        ResponseEntity<String> response = restTemplate.getForEntity(instrumentsUrl, String.class);

        try {
            Instrument[] instruments = objectMapper.readValue(response.getBody(), Instrument[].class);
            return ResponseEntity.ok(instruments);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PostMapping("/sendTradeRequest")
    public ResponseEntity<Trade> sendTradeRequest(@RequestBody Order order) {
    	
    	try {
			tradeService.createOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TradeException("Cannot create order", e);
		}
    	
        String url = nodeServiceBaseUrl + "/trade"; 

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Order> requestEntity = new HttpEntity<>(order, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            requestEntity,
            String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            Trade trade;
			try {
				trade = objectMapper.readValue(response.getBody(), Trade.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new TradeException("Cannot create trade object", e);
			}
            
            tradeService.createTrade(trade);
            
            return ResponseEntity.ok(trade);
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(null);
        }
    }
    
    @GetMapping("/tradeHistory/{clientId}")
    public ResponseEntity<List<Trade>> getTradeHistory(@PathVariable String clientId) {
        try {
            List<Trade> tradeHistory = tradeService.getTradeHistory(clientId);
            return ResponseEntity.ok(tradeHistory);
        } catch (TradeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/portfolio/{clientId}")
    public ResponseEntity<List<Trade>> getPortfolio(@PathVariable String clientId) {
        try {
            List<Trade> portfolio = tradeService.getPortfolio(clientId);
            return ResponseEntity.ok(portfolio);
        } catch (TradeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/roboadvisor/buy/{clientId}")
    public ResponseEntity<Price[]> getBuyStocks(@PathVariable String clientId) {
    	InvestmentPreference preferences = preferenceService.getPreferencebyId(clientId);
    	RiskTolerance tolerance = preferences.getRiskTolerance();
    	if(tolerance.equals(RiskTolerance.AGGRESSIVE)) {
    		String pricesUrl = nodeServiceBaseUrl + "/prices/STOCK";
    		ResponseEntity<String> response = restTemplate.getForEntity(pricesUrl, String.class);
            try {
                Price[] prices = objectMapper.readValue(response.getBody(), Price[].class);
                return ResponseEntity.ok(prices);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
    	} else if(tolerance.equals(RiskTolerance.BELOW_AVERAGE) || tolerance.equals(RiskTolerance.AVERAGE) || tolerance.equals(RiskTolerance.ABOVE_AVERAGE)) {
    		String pricesUrl = nodeServiceBaseUrl + "/prices/GOVT";
    		ResponseEntity<String> response = restTemplate.getForEntity(pricesUrl, String.class);
            try {
                Price[] prices = objectMapper.readValue(response.getBody(), Price[].class);
                return ResponseEntity.ok(prices);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
    	} else {
    		String pricesUrl = nodeServiceBaseUrl + "/prices/CD";
    		ResponseEntity<String> response = restTemplate.getForEntity(pricesUrl, String.class);
            try {
                Price[] prices = objectMapper.readValue(response.getBody(), Price[].class);
                return ResponseEntity.ok(prices);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
    	}
    }
}
