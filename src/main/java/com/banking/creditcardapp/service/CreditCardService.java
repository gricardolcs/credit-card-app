package com.banking.creditcardapp.service;

import com.banking.creditcardapp.exceptions.CreditCardException;
import com.banking.creditcardapp.model.CreditCard;

public interface CreditCardService {
	
	/**
	 * Validate credit card details.
	 * 
	 * @param card 
	 * 			CreditCard, represents a credit card.
	 * 
	 * @throws CreditCardException
	 */
	void validate(final CreditCard card) throws CreditCardException;
}
