package com.jb.currency.exchange.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.jb.currency.exchange.cache.CacheManager;

@Configuration
public class BeansConfig {

	@Bean
	public CacheManager cacheManager() {
		return new CacheManager();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
