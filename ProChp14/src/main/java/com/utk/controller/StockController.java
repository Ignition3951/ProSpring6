package com.utk.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;

import com.utk.entity.Stock;

import jakarta.annotation.PostConstruct;

@Controller
public class StockController {

	private final TaskScheduler taskScheduler;

	private final SimpMessagingTemplate messagingTemplate;

	public StockController(TaskScheduler taskScheduler, SimpMessagingTemplate messagingTemplate) {
		this.taskScheduler = taskScheduler;
		this.messagingTemplate = messagingTemplate;
	}

	private List<Stock> stocks = new ArrayList<>();
	private Random random = new Random(System.currentTimeMillis());

	@MessageMapping("/addStock")
	public void addStock(Stock stock) {
		stocks.add(stock);
		broadcastUpdatedPrices();
	}

	private void broadcastUpdatedPrices() {
		for (Stock stock : stocks) {
			stock.setPrice(stock.getPrice() + (getUpdatedStockPrice() * stock.getPrice()));
			stock.setDate(LocalDateTime.now());
		}
		messagingTemplate.convertAndSend("/topic/price", stocks);
	}

	private double getUpdatedStockPrice() {
		double priceChange = random.nextDouble() * 5.0;
		if (random.nextInt(2) == 1) {
			priceChange -= priceChange;
		}
		return priceChange / 100.0;
	}

	@PostConstruct
	private void broadcastTimePeriodically() {
		stocks.add(new Stock("VMW", 1.00d));
		stocks.add(new Stock("EMC", 1.00d));
		stocks.add(new Stock("GOOG", 1.00d));
		stocks.add(new Stock("IBM", 1.00d));
		taskScheduler.scheduleAtFixedRate(this::broadcastUpdatedPrices, Duration.ofSeconds(2));
	}
}
