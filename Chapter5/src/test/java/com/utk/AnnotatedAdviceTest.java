package com.utk;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.AspectJAopConfig;
import com.utk.model.NewDocumentarist;

public class AnnotatedAdviceTest {

	@Test
	void testBeforeAdviceV1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectJAopConfig.class);
		assertTrue(Arrays.asList(context.getBeanDefinitionNames()).contains("beforeAdviceV1"));

		NewDocumentarist documentarist = context.getBean("documentarist", NewDocumentarist.class);
		documentarist.execute();
		context.close();

	}

}
