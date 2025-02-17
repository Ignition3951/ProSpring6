package com.utk;

import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.utk.util.BubbleSort;
import com.utk.util.InsertionSort;
import com.utk.util.MergeSort;
import com.utk.util.QuickSort;
import com.utk.util.ThreadPoolMonitor;

public class ClassicDemo {

	public static void main(String[] args) {
		int[] arr = new Random().ints(100000, 0, 500000).toArray();
//		int[] checkarr = { 23, 1, 10, 5, 2 };
		ThreadPoolMonitor algorithmMonitor = new ThreadPoolMonitor();
		Thread algoThread = new Thread(algorithmMonitor);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 4, 0l, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>());
		algorithmMonitor.setExecutor(threadPoolExecutor);
		List.of(new BubbleSort(arr), new InsertionSort(arr), new MergeSort(arr), new QuickSort(arr))
				.forEach(threadPoolExecutor::execute);
		algoThread.start();
		threadPoolExecutor.shutdown();
		try {
			threadPoolExecutor.awaitTermination(30, TimeUnit.MINUTES);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
