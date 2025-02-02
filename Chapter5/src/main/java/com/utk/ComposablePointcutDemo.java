package com.utk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.utk.aop.SimpleBeforeAdvice;
import com.utk.aop.pointcut.RestMethodMatcher;
import com.utk.aop.pointcut.SingMethodMatcher;
import com.utk.aop.pointcut.TalkMethodMatcher;
import com.utk.service.impl.GrammyGuitarist;

public class ComposablePointcutDemo {

	private static Logger logger = LoggerFactory.getLogger(ComposablePointcutDemo.class);

	public static void main(String[] args) {
		GrammyGuitarist grammyGuitarist = new GrammyGuitarist();
		ComposablePointcut composablePointcut = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());
		logger.info("TEST 1 >>");
		GrammyGuitarist proxy = getProxy(composablePointcut, grammyGuitarist);
		testInvoke(proxy);

		logger.info("TEST 2 >>");
		composablePointcut.union(new TalkMethodMatcher());
		proxy = getProxy(composablePointcut, grammyGuitarist);
		testInvoke(proxy);

		logger.info("TEST 3 >>");
		composablePointcut.intersection(new RestMethodMatcher());
		proxy = getProxy(composablePointcut, grammyGuitarist);
		testInvoke(proxy);

	}

	private static GrammyGuitarist getProxy(ComposablePointcut pointcut, GrammyGuitarist target) {
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvisor(advisor);
		return (GrammyGuitarist) factory.getProxy();
	}

	private static void testInvoke(GrammyGuitarist proxy) {
		proxy.sing();
		proxy.sing("From Test Invoke");
		proxy.talk();
		proxy.rest();
	}

}
