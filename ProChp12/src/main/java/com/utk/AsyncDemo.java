package com.utk;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.AsyncConfig;
import com.utk.service.AsyncService;

public class AsyncDemo {

	public static Logger logger = LoggerFactory.getLogger(AsyncDemo.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class)) {
			AsyncService asyncService = context.getBean("asyncService", AsyncService.class);

			for (int i = 0; i < 5; i++) {
				asyncService.asyncTask();
			}

			Future<String> johnMayer = asyncService.asyncWithReturn("JohnMayer");
			Future<String> ericClapton = asyncService.asyncWithReturn("EricClapton");
			Future<String> bbKing = asyncService.asyncWithReturn("BBKing");
			Thread.sleep(6000);

			logger.info(">> REsult 1: " + johnMayer.get());
			logger.info(">> REsult 2: " + ericClapton.get());
			logger.info(">> REsult 3: " + bbKing.get());

			System.in.read();
		}
	}

}
