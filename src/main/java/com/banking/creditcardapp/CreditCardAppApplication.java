package com.banking.creditcardapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.banking.creditcardapps"})
public class CreditCardAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardAppApplication.class, args);
	}

}
