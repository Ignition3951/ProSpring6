package com.utk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.ChildConfig;
import com.utk.config.ParentConfig;
import com.utk.model.Song;

public class ContextNestingDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
		parentContext.register(ParentConfig.class);
		parentContext.refresh();

		AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
		childContext.register(ChildConfig.class);
		childContext.setParent(parentContext);
		childContext.refresh();
		Song song1 = (Song) childContext.getBean("song1");
		Song song2 = (Song) childContext.getBean("song2");
		Song song3 = (Song) childContext.getBean("song3");

		System.out.println("song1 : " + song1.getTitle());
		System.out.println("song2 : " + song2.getTitle());
		System.out.println("song3 : " + song3.getTitle());

		childContext.close();

	}

}
