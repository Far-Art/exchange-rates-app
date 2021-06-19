package com.jb.currency.exchange.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jb.currency.exchange.beans.CurrencyObject;
import com.jb.currency.exchange.repos.CurrencyRepository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CacheManager {

	@Autowired
	private CurrencyRepository repository;

	/**
	 * Cache for fetched Data from Database
	 */
	@Getter
	private static final Map<String, CurrencyObject> CACHE = new HashMap<String, CurrencyObject>();

	public CurrencyObject getCurrency(String currency) {
		/**
		 * if cache contains data, return it, else fetch data from Database and add to
		 * cache
		 */
		if (CACHE.containsKey(currency)) {
			System.out.println("--- Cache invoked ---");
			return CACHE.get(currency);
		}

		CurrencyObject result = repository.getCurrency(currency);
		CACHE.put(currency.toUpperCase(), result);

		return result;
	}

}
