package com.utk.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.AutoWiringCfg;
import com.utk.model.Foo;
import com.utk.model.Target;

public class AutoWiringDemo {

	private static Logger logger = LoggerFactory.getLogger(AutoWiringDemo.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoWiringCfg.class);
		Target target = context.getBean(Target.class);
		logger.info("Created target? {}", target != null);
		logger.info("Created bar? {}", Target.barOne != null);
		logger.info("Created fooOne? {}", Target.fooOne != null ? Foo.id : "");
		logger.info("Created fooTwo? {}", Target.fooTwo != null ? Foo.id : "");

		context.close();
	}

}
