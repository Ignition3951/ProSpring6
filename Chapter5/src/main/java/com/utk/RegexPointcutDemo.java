package com.utk;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

import com.utk.aop.SimpleAroundAdvice;
import com.utk.service.impl.Guitarist;

public class RegexPointcutDemo {

	public static void main(String[] args) {
		Guitarist guitarist = new Guitarist();

		JdkRegexpMethodPointcut regexpMethodPointcut = new JdkRegexpMethodPointcut();
		regexpMethodPointcut.setPattern(".*sing.*");
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(regexpMethodPointcut, new SimpleAroundAdvice());

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor);
		proxyFactory.setTarget(guitarist);
		Guitarist guitaristSinger = (Guitarist) proxyFactory.getProxy();
		guitaristSinger.sing();
		guitaristSinger.sing2();
		guitaristSinger.rest();

	}

}
