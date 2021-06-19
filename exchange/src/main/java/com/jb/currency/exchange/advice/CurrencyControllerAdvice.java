package com.jb.currency.exchange.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jb.currency.exchange.exceptions.CurrencyExchangeException;

@RestControllerAdvice
public class CurrencyControllerAdvice {

	@ExceptionHandler(CurrencyExchangeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String error(Exception e) {
		return e.getMessage();
	}
}
