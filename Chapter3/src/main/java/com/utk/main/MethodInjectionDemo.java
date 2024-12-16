package com.utk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

import com.utk.config.MethodInjectionDemoConfig;
import com.utk.model.KeyHelper;
import com.utk.model.LockOpener;

public class MethodInjectionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				MethodInjectionDemoConfig.class);
		LockOpener standardLockOpener = context.getBean("standardLockOpener", LockOpener.class);
		LockOpener abstractLockOpener = context.getBean("abstractLockOpener", LockOpener.class);

		displayInfo("standardLockOpener", standardLockOpener);
		displayInfo("abstractLockOpener", abstractLockOpener);

		context.close();
	}

	public static void displayInfo(String beanName, LockOpener lockOpener) {
		KeyHelper keyHelperOne = lockOpener.getMyKeyOpener();
		KeyHelper keyHelperTwo = lockOpener.getMyKeyOpener();

		System.out.println("[" + beanName + "]: KeyHelper Instances the Same? " + (keyHelperOne == keyHelperTwo));

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("MethodInjDemo");

		for (int i = 0; i < 100000; i++) {
			KeyHelper keyHelper = lockOpener.getMyKeyOpener();
			keyHelper.open();
		}

		stopWatch.stop();
		System.out.println("Time taken : " + stopWatch.getTotalTimeMillis() + " ms.");
	}

}
