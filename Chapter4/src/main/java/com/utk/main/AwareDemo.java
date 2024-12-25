package com.utk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.AwareConfig;
import com.utk.model.NamedSinger;

public class AwareDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		context.registerShutdownHook();
		NamedSinger namedSinger = (NamedSinger) context.getBean("johnMayer");
		namedSinger.sing();

	}

}
