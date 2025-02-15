package com.utk.util;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSort implements IntSortingTask {

	private static final Logger logger = LoggerFactory.getLogger(AbstractSort.class);

	protected String name;

	protected final int[] arr;

	public AbstractSort(int[] arr) {
		this.arr = IntStream.of(arr).toArray();
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		sort(arr);
		long endTime = System.currentTimeMillis();
		float seconds = ((float) (endTime - startTime)) / 1000;
		logger.info("{} Sort Time: {} seconds ", name, seconds);
//		print(arr);
	}

	public void print(int[] arr) {
		logger.info("-----------Sorted array is : -----------------");
		for (int i = 0; i < arr.length; i++) {
			logger.info("" + arr[i]);
		}

	}

}
