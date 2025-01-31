package com.utk;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.utk.aop.SimpleAroundAdvice;
import com.utk.aop.pointcut.SimpleDynamicPointcut;
import com.utk.service.Singer;
import com.utk.service.impl.GoodGuitarist;

public class DynamicPointcutDemo {

	public static void main(String[] args) {
		GoodGuitarist goodGuitarist = new GoodGuitarist();
		Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAroundAdvice());
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(goodGuitarist);
		proxyFactory.addAdvisor(advisor);
		Singer singer = (Singer) proxyFactory.getProxy();
		singer.sing("C");
		singer.sing("c");
		singer.sing("E");

		singer.sing();
	}

}
