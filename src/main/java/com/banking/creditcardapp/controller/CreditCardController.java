package com.banking.creditcardapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.creditcardapp.exceptions.CreditCardException;
import com.banking.creditcardapp.model.CreditCard;
import com.banking.creditcardapp.model.CreditCardResponseDTO;
import com.banking.creditcardapp.service.CreditCardService;

@RestController
@RequestMapping("/api")
public class CreditCardController {
	
	public static final Logger LOG = LoggerFactory.getLogger(CreditCardController.class);
	
	@Autowired
	@Qualifier("creditCardService")
	private CreditCardService creditCardService;
	
	@RequestMapping(value ="/credit-card/{number}", method = RequestMethod.GET) 
	public ResponseEntity<?> validateCreditCard(@PathVariable("number") final String number,
												@RequestParam(value = "expiry_date", required = true) final String expiryDate,
												@RequestParam(value = "amount", required = true) final Double amount,
												@RequestParam(value = "holder_name", required = false) final String holderName
			) {
		LOG.info("Validating Credit Card, number: {}", number);
		
		CreditCard creditCard = new CreditCard(number, expiryDate, amount);
		
		try {
			this.creditCardService.validate(creditCard);
		} catch(CreditCardException e) {
			return new ResponseEntity<CreditCardResponseDTO>(new CreditCardResponseDTO(creditCard.getNumber(), false, e.getMessage()),
													  		 HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CreditCardResponseDTO>(new CreditCardResponseDTO(creditCard.getNumber(), true, "OK"), 
														 HttpStatus.OK);
	}
}

