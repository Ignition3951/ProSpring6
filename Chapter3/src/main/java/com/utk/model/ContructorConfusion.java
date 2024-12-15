package com.utk.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContructorConfusion {

	private String someValue;

	public ContructorConfusion(String someValue) {
		System.out.println("ContructorConfusion(String someValue) is called!!!!!!");
		this.someValue = someValue;
	}

	@Autowired
	public ContructorConfusion(@Value("60") int someValue) {
		System.out.println("ContructorConfusion @Value(60) is called!!!!!!");
		this.someValue = "NUMBER : " + someValue;
	}

	@Override
	public String toString() {
		return "ContructorConfusion [someValue=" + someValue + "]";
	}

}
