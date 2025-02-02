package com.utk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.utk.aop.SimpleBeforeAdvice;
import com.utk.model.TestBean;

public class ControlFlowDemo {

	private Logger logger = LoggerFactory.getLogger(ControlFlowDemo.class);

	public static void main(String[] args) {
		ControlFlowDemo controlFlowDemo = new ControlFlowDemo();
		controlFlowDemo.run();
	}

	public void run() {
		TestBean bean = new TestBean();
		Pointcut pointcut = new ControlFlowPointcut(ControlFlowDemo.class, "test");
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(bean);
		factory.addAdvisor(advisor);

		TestBean testBean = (TestBean) factory.getProxy();
		logger.info("/t Trying normal invoke.");
		testBean.foo();
		logger.info("/t Trying invoke from test method.");
		test(testBean);
	}

	public void test(TestBean testBean) {
		testBean.foo();
	}

}
