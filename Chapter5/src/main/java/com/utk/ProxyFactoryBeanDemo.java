package com.utk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.AopConfig;
import com.utk.model.Documentarist;

public class ProxyFactoryBeanDemo {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);) {
		Documentarist documentaristOne = context.getBean("documentaristOne", Documentarist.class);
		Documentarist documentaristTwo = context.getBean("documentaristTwo", Documentarist.class);

		System.out.println("Documentarist One >>>>");
		documentaristOne.execute();

		System.out.println("Documentarist Two >>>>");
		documentaristTwo.execute();
	}
}

}
