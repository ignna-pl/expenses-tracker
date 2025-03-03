package com.expenses.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ExpensesTrackerApplication {

	public static void main(String[] args) {
		String idForEncode = "bcrypt";
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put(idForEncode, new BCryptPasswordEncoder());

		PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

		String rawPassword = "password";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		System.out.println("Encoded Password: " + encodedPassword);

		SpringApplication.run(ExpensesTrackerApplication.class, args);
	}

}
