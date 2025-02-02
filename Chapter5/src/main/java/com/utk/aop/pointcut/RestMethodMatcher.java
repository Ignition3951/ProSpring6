package com.utk.aop.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcher;

public class RestMethodMatcher extends StaticMethodMatcher {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return (method.getName().endsWith("st"));
	}

}
