package com.utk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAdviceV1 {

	private static Logger logger = LoggerFactory.getLogger(BeforeAdviceV1.class);

	@Before("execution(* com.utk.service.impl..sing*(com.utk.model.Guitar))")
	public void simpleBeforeAdvice(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		logger.info(">> Executing: {} from {}", signature.getName(), signature.getDeclaringTypeName());
	}

}
