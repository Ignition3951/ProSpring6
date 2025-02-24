package com.utk.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.utk.service.AsyncService;

public class AsyncServiceImpl implements AsyncService {

	public static Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

	@Async
	@Override
	public void asyncTask() {
		logger.info("Start execution of async task.");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			logger.error("Task interrupted!!!", e);
		}
		logger.info("Complete execution of async task.");
	}

	@Async
	@Override
	public Future<String> asyncWithReturn(String name) {
		logger.info("Start execution of async task with return : {}", name);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			logger.error("Task interrupted!!!", e);
		}
		logger.info("Completed execution of async task with return : {}", name);
		return CompletableFuture.completedFuture("Hello : " + name);
	}

}
