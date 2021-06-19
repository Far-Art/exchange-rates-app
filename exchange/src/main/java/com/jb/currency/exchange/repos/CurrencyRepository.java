package com.jb.currency.exchange.repos;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.jb.currency.exchange.beans.CurrencyObject;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CurrencyRepository {

//	private final String API_KEY = "1cbb556b7a392097573c0294";

//	private final String PAIR_CURRENCY_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

	private final String CURRENCY_URL = "https://api.exchangerate-api.com/v4/latest/";

	private final RestTemplate restTemplate;

	public CurrencyObject getCurrency(String currencyCode) {
		CurrencyObject result = restTemplate.getForObject(CURRENCY_URL + currencyCode, CurrencyObject.class);
		result.setBaseCurrency(currencyCode);
		return result;
	}

//	public CurrencyObject getPairCurrency(String baseCurrencyCode, String targetCurrencyCode) {
//		String values = baseCurrencyCode + "/" + targetCurrencyCode;
//		return restTemplate.getForObject(PAIR_CURRENCY_URL + values, CurrencyObject.class);
//	}
}
