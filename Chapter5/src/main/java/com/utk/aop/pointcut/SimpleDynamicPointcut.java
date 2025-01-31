package com.utk.aop.pointcut;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.utk.service.impl.GoodGuitarist;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	private static Logger logger = LoggerFactory.getLogger(SimpleDynamicPointcut.class);

	@Override
	public ClassFilter getClassFilter() {
		return cls -> (cls == GoodGuitarist.class);
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return ("sing".equals(method.getName()));
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		logger.info("Dynamic method for " + method.getName());
		if (args.length == 0)
			return false;
		String value = (String) args[0];
		return value.equalsIgnoreCase("C");
	}

}
