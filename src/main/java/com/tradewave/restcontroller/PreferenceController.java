package com.tradewave.restcontroller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradewave.business.InvestmentPreference;
import com.tradewave.restservices.PreferenceDatabaseException;
import com.tradewave.restservices.PreferenceService;




@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {
	@Autowired
	private PreferenceService service;
	@GetMapping(value="/ping",
			produces=MediaType.ALL_VALUE)
	public String ping() {
		return "Preference web service is alive at " + LocalDateTime.now();
	}
	@GetMapping(value="/listPreference/{id}")
	public ResponseEntity<InvestmentPreference> getPreferencebyId(@PathVariable String id){
		InvestmentPreference invPref=null;
		ResponseEntity<InvestmentPreference> response;
		try {
		invPref = service.getPreferencebyId(id);
		} catch(PreferenceDatabaseException e) {
			response=ResponseEntity.notFound().build();
		}
		if(invPref!=null) {
			response=ResponseEntity.status(HttpStatus.OK).body(invPref);
		}
		else {
			response=ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return response;
	}
	@PostMapping(value="/insert")
	public ResponseEntity<DatabaseRequestResult> insertPreference(@RequestBody InvestmentPreference invPref) {
		int count=0;
		ResponseEntity<DatabaseRequestResult> response;
		if(invPref==null) {
			response=ResponseEntity.status(422).build();
		}
		else {
			count=service.insertPreference(invPref);
			response=ResponseEntity.status(200).body(new DatabaseRequestResult(count));
		}
		return response;
	}
	@PutMapping(value="/update")
	public ResponseEntity<DatabaseRequestResult> updatePreference(@RequestBody InvestmentPreference invPref) {
		int count=0;
		ResponseEntity<DatabaseRequestResult> response;
		if(invPref==null) {
			response=ResponseEntity.status(422).build();
		}
		else {
			count=service.updatePreference(invPref);
			response=ResponseEntity.status(202).body(new DatabaseRequestResult(count));
		}
		return response;
	}
}
