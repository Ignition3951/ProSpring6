package com.utk.model;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Foo {

	public static String id = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
}
