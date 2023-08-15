package com.banking.creditcardapp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.banking.creditcardapp.model.BlacklistDTO;
import com.banking.creditcardapp.model.CreditCard;
import com.google.gson.Gson;

 
@Service
public class BasicBlacklistService implements BlacklistService {
	private String filePath;
	private BlacklistDTO blacklistDto;
	
	public BasicBlacklistService(@Value("${blacklist.file.path}") final String filePath) throws IOException {
		this.filePath = filePath;
		String json = new String(Files.readAllBytes(Paths.get(this.filePath)));
        Gson gson = new Gson();
        BlacklistDTO bl = gson.fromJson(json, BlacklistDTO.class);
        
        List<String> blacklistNumbers = bl.getBlacklist().stream()
        												 .map(s -> { 
        													 	return s.trim().replaceAll("\\s", "");
        												 	 })
        												 .collect(Collectors.toList());
        this.blacklistDto = new BlacklistDTO(blacklistNumbers);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBlacklisted(CreditCard card) {
		return this.blacklistDto.getBlacklist().contains(card.getNumber()
															 .replaceAll("\\s", "")
															 .trim());
	}
}
