package com.utk;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import com.utk.annotation.AdviceRequired;
import com.utk.aop.SimpleAroundAdvice;
import com.utk.model.Guitar;
import com.utk.service.impl.AnnotatedGuitarist;

public class AnnotationPointcutDemo {

	public static void main(String[] args) {
		AnnotatedGuitarist guitarist = new AnnotatedGuitarist();
		AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);

		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(guitarist);
		proxyFactory.addAdvisor(advisor);
		AnnotatedGuitarist annotatedGuitarist = (AnnotatedGuitarist) proxyFactory.getProxy();

		annotatedGuitarist.sing(new Guitar());
		annotatedGuitarist.rest();
	}

}
