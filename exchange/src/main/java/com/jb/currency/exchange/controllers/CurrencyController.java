package com.jb.currency.exchange.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.currency.exchange.exceptions.CurrencyExchangeException;
import com.jb.currency.exchange.services.ExchangeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("currency")
public class CurrencyController {
	private final ExchangeService service;

	@GetMapping("rates/{currency}")
	public ResponseEntity<?> getRatesFor(@PathVariable String currency) throws CurrencyExchangeException {
		return new ResponseEntity<>(service.getCurrency(currency).getInfo(), HttpStatus.ACCEPTED);
	}

	@GetMapping("rates/exchange")
	public ResponseEntity<?> getExchangeRates(@RequestParam(name = "base") String baseCurrency,
			@RequestParam(name = "target") String targetCurrency, @RequestParam(defaultValue = "1") int amount)
			throws CurrencyExchangeException {
		return new ResponseEntity<>(service.getCurrency(baseCurrency, targetCurrency, amount).getInfo(),
				HttpStatus.ACCEPTED);
	}
}
