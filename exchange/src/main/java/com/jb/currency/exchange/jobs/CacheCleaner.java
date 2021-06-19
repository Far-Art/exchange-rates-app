package com.jb.currency.exchange.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jb.currency.exchange.cache.CacheManager;

@Component
public class CacheCleaner {

	@Scheduled(fixedDelay = 86_400_000)
	private void cleanCache() {
		CacheManager.getCACHE().clear();
	}
}
