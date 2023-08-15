package com.banking.creditcardapp.service;

import com.banking.creditcardapp.model.CreditCard;

public interface BlacklistService {
	/**
	 * Check if the given credit card is blacklisted.
	 * 
	 * @param card
	 * 			CreditCard, card to check
	 * 
	 * @return boolean
	 * 			true if it's blacklisted false otherwise
	 */
	boolean isBlacklisted(final CreditCard card);
}
