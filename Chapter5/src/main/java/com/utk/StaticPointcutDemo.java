package com.utk;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.utk.aop.SimpleAroundAdvice;
import com.utk.aop.pointcut.SimpleStaticPointcut;
import com.utk.service.Singer;
import com.utk.service.impl.GoodGuitarist;
import com.utk.service.impl.GreatGuitarist;

public class StaticPointcutDemo {

	public static void main(String[] args) {
		GoodGuitarist johnMayer = new GoodGuitarist();
		GreatGuitarist ericClapton = new GreatGuitarist();

		Singer proxyOne;
		Singer proxyTwo;

		Pointcut pt = new SimpleStaticPointcut();
		Advice advice = new SimpleAroundAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pt, advice);
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor);
		proxyFactory.setTarget(johnMayer);
		proxyOne = (Singer) proxyFactory.getProxy();

		proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor);
		proxyFactory.setTarget(ericClapton);
		proxyTwo = (Singer) proxyFactory.getProxy();

		proxyOne.sing();
		proxyTwo.sing();

	}

}
