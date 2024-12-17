package com.utk.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class Target {

	private static Logger logger = LoggerFactory.getLogger(Target.class);
	public static Foo fooOne;
	public static Foo fooTwo;
	public static Bar barOne;

	public Target() {
		logger.info(" --> Target() called");
	}

	public Target(Foo foo) {
		fooOne = foo;
		logger.info(" --> Target(Foo) called");
	}

	public Target(Foo foo, Bar bar) {
		fooTwo = foo;
		barOne = bar;
		logger.info(" --> Target(Foo foo,Bar bar) called");
	}
}
