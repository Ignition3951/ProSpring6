package com.utk.util;

import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolMonitor implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(ThreadPoolMonitor.class);

	protected ThreadPoolExecutor threadPoolExecutor;
	protected int printInterval = 200;

	@Override
	public void run() {
		try {
			while (threadPoolExecutor.getActiveCount() > 0) {
				monitorThreadPool();
				Thread.sleep(printInterval);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private void monitorThreadPool() {
		String strBuff = "CurrentPoolSize : " + threadPoolExecutor.getPoolSize() + " - CorePoolSize : "
				+ threadPoolExecutor.getCorePoolSize() + " - MaximumPoolSize : "
				+ threadPoolExecutor.getMaximumPoolSize() + " - ActiveTaskCount : "
				+ threadPoolExecutor.getActiveCount() + " - CompletedTaskCount : "
				+ threadPoolExecutor.getCompletedTaskCount() + " - TotalTaskCount : "
				+ threadPoolExecutor.getTaskCount() + " - isTerminated : " + threadPoolExecutor.isTerminated();
		logger.info(strBuff);
	}

	public void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
		this.threadPoolExecutor = threadPoolExecutor;
	}

}
