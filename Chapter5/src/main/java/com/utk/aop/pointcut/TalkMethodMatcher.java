package com.utk.aop.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcher;

public class TalkMethodMatcher extends StaticMethodMatcher {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return ("talk".equals(method.getName()));
	}

}
