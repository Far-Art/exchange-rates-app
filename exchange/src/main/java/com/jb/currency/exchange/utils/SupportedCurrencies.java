package com.jb.currency.exchange.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

public class SupportedCurrencies {

	/**
	 * HashSet uses O(1) time complexity for contains() operation
	 */
	@Getter
	private static final Set<String> currencies = new HashSet<>(Arrays.asList("FJD", "MXN", "SCR", "TVD", "CDF", "BBD",
			"GTQ", "CLP", "HNL", "UGX", "ZAR", "TND", "STN", "CUC", "BSD", "SLL", "SDG", "IQD", "CUP", "GMD", "TWD",
			"RSD", "DOP", "KMF", "MYR", "FKP", "XOF", "GEL", "UYU", "MAD", "CVE", "TOP", "AZN", "OMR", "PGK", "KES",
			"SEK", "BTN", "UAH", "GNF", "ERN", "MZN", "ARS", "QAR", "IRR", "CNY", "THB", "UZS", "XPF", "MRU", "BDT",
			"LYD", "BMD", "KWD", "PHP", "RUB", "PYG", "ISK", "JMD", "COP", "USD", "MKD", "DZD", "PAB", "GGP", "SGD",
			"ETB", "KGS", "SOS", "VUV", "LAK", "BND", "XAF", "LRD", "CHF", "HRK", "ALL", "DJF", "VES", "ZMW", "TZS",
			"VND", "AUD", "ILS", "GHS", "GYD", "BOB", "KHR", "MDL", "IDR", "KYD", "AMD", "BWP", "SHP", "TRY", "LBP",
			"TJS", "JOD", "AED", "HKD", "RWF", "EUR", "FOK", "LSL", "DKK", "CAD", "KID", "BGN", "MMK", "MUR", "NOK",
			"SYP", "IMP", "GIP", "RON", "LKR", "NGN", "CRC", "CZK", "PKR", "XCD", "ANG", "HTG", "BHD", "KZT", "SRD",
			"SZL", "SAR", "TTD", "YER", "MVR", "AFN", "INR", "AWG", "KRW", "NPR", "JPY", "MNT", "AOA", "PLN", "GBP",
			"SBD", "BYN", "HUF", "BIF", "MWK", "MGA", "XDR", "BZD", "BAM", "EGP", "MOP", "NAD", "SSP", "NIO", "PEN",
			"NZD", "WST", "TMT", "BRL"));
}
