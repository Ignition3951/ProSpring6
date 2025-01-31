package com.utk.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class SimpleAroundAdvice implements org.aopalliance.intercept.MethodInterceptor {

	private static Logger logger = LoggerFactory.getLogger(SimpleAroundAdvice.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		logger.info("Around : Starting timer ");
		StopWatch sw = new StopWatch();
		sw.start(invocation.getMethod().getName());
		Object returnValue = invocation.proceed();
		sw.stop();
		logger.info("Around: Concert Duration : {}", sw.getTotalTimeMillis());
		return returnValue;
	}


}
