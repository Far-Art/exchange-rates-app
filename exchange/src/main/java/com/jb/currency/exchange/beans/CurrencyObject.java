package com.jb.currency.exchange.beans;

import java.util.HashMap;
import java.util.Map.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyObject {

	private double baseAmount = 1;
	private double targetAmount;
	private String baseCurrency;
	private String targetCurrency;
	private HashMap<String, Double> rates;

	public String getInfo() {
		String info;
		if (targetCurrency == null) {
			info = "Rates relative to " + baseCurrency + " \n{";
			for (Entry<?, ?> entry : rates.entrySet()) {
				info += ", \n" + entry;
			}
			info += "\n}";
		} else {
			info = baseAmount + " " + baseCurrency + " = " + targetAmount + " " + targetCurrency;
		}
		return info;
	}

}
