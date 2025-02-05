package com.utk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.utk.aspect.BeforeAdviceV1;
import com.utk.model.NewDocumentarist;
import com.utk.service.impl.GrammyGuitarist;

@ComponentScan(basePackageClasses = { BeforeAdviceV1.class, NewDocumentarist.class, GrammyGuitarist.class })
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectJAopConfig {

}
