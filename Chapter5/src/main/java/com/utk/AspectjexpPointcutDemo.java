package com.utk;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.utk.aop.SimpleAroundAdvice;
import com.utk.service.impl.Guitarist;

public class AspectjexpPointcutDemo {

	public static void main(String[] args) {
		Guitarist guitarist = new Guitarist();

		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* sing*(..))");
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor);
		proxyFactory.setTarget(guitarist);
		Guitarist guitaristSinger = (Guitarist) proxyFactory.getProxy();
		guitaristSinger.sing();
		guitaristSinger.sing2();
		guitaristSinger.rest();

	}

}
