package com.jb.currency.exchange.services;

import org.springframework.stereotype.Service;

import com.jb.currency.exchange.beans.CurrencyObject;
import com.jb.currency.exchange.cache.CacheManager;
import com.jb.currency.exchange.exceptions.CurrencyExchangeException;
import com.jb.currency.exchange.utils.SupportedCurrencies;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExchangeService {

	private final CacheManager cacheManager;

	/**
	 * Get relative rates to passed currency
	 * 
	 * @param currencyCode
	 * @return
	 * @throws CurrencyExchangeException
	 */
	public CurrencyObject getCurrency(String currencyCode) throws CurrencyExchangeException {
		/* check base currency existence */
		if (!SupportedCurrencies.getCurrencies().contains(currencyCode.toUpperCase())) {
			throw new CurrencyExchangeException(
					"Such Currency (" + currencyCode.toUpperCase() + ") is not supported or not exist");
		}

		return cacheManager.getCurrency(currencyCode.toUpperCase());
	}

	public CurrencyObject getCurrency(String baseCurrency, String targetCurrency) throws CurrencyExchangeException {
		/* check target currency existence */
		if (!SupportedCurrencies.getCurrencies().contains(targetCurrency.toUpperCase())) {
			throw new CurrencyExchangeException(
					"Such Currency (" + targetCurrency.toUpperCase() + ") is not supported or not exist");
		}

		/* check if base and target currencies are the same */
		if (baseCurrency.equalsIgnoreCase(targetCurrency)) {
			throw new CurrencyExchangeException("Base and target currencies cannot be the same");
		}

		/* values setters */
		CurrencyObject result = getCurrency(baseCurrency);
		result.setTargetAmount(result.getRates().get(targetCurrency.toUpperCase()));
		result.setTargetCurrency(targetCurrency.toUpperCase());

		return result;
	}

	public CurrencyObject getCurrency(String baseCurrency, String targetCurrency, int amount)
			throws CurrencyExchangeException {

		/* check amount */
		if (amount <= 0) {
			throw new CurrencyExchangeException("Amount cannot be less than 0");
		}

		/* values setters */
		CurrencyObject result = getCurrency(baseCurrency, targetCurrency);
		result.setBaseAmount(amount);
		result.setTargetAmount(result.getRates().get(targetCurrency.toUpperCase()) * amount);

		return result;
	}

}
