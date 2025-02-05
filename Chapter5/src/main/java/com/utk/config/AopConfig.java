package com.utk.config;

import org.aopalliance.aop.Advice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utk.aop.AuditAdvice;
import com.utk.model.Documentarist;
import com.utk.service.impl.GrammyGuitarist;

@Configuration
public class AopConfig implements BeanFactoryAware {

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Bean
	public GrammyGuitarist johnMayer() {
		return new GrammyGuitarist();
	}

	@Bean
	public Advice advice() {
		return new AuditAdvice();
	}

	@Bean
	public GrammyGuitarist proxyOne() {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyTargetClass(true);
		proxyFactoryBean.setTarget(johnMayer());
		proxyFactoryBean.setInterceptorNames("advice");
		proxyFactoryBean.setBeanFactory(beanFactory);
		proxyFactoryBean.setFrozen(true);
		return (GrammyGuitarist) proxyFactoryBean.getObject();
	}

	@Bean
	public Documentarist documentaristOne() {
		Documentarist documentarist = new Documentarist();
		documentarist.setDep(proxyOne());
		return documentarist;
	}

	@Bean
	public DefaultPointcutAdvisor advisor() {
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setAdvice(advice());
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* sing*(..))");
		advisor.setPointcut(pointcut);
		return advisor;
	}

	@Bean
	public GrammyGuitarist proxyTwo() {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyTargetClass(true);
		proxyFactoryBean.setTarget(johnMayer());
		proxyFactoryBean.setInterceptorNames("advisor");
		proxyFactoryBean.setBeanFactory(beanFactory);
		proxyFactoryBean.setFrozen(true);
		return (GrammyGuitarist) proxyFactoryBean.getObject();
	}

	@Bean
	public Documentarist documentaristTwo() {
		Documentarist documentarist = new Documentarist();
		documentarist.setDep(proxyTwo());
		return documentarist;
	}

}
