package com.utk;

import org.springframework.aop.framework.ProxyFactory;

import com.utk.aop.SimpleAfterAdvice;
import com.utk.aop.SimpleAroundAdvice;
import com.utk.aop.SimpleBeforeAdvice;
import com.utk.service.Performance;
import com.utk.service.impl.Concert;

public class ManualAdviceDemo {

	public static void main(String[] args) {
		Concert concert = new Concert();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(new SimpleBeforeAdvice());
		proxyFactory.addAdvice(new SimpleAroundAdvice());
		proxyFactory.addAdvice(new SimpleAfterAdvice());
		proxyFactory.setTarget(concert);

		Performance performance = (Performance) proxyFactory.getProxy();
		performance.execute();
	}

}
