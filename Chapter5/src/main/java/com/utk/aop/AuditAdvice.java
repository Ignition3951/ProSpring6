package com.utk.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class AuditAdvice implements MethodBeforeAdvice {

	private static Logger logger = LoggerFactory.getLogger(AuditAdvice.class);

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("Executing : {}", method);
	}

}
