package com.github.openkengboy.validation.config;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {
//	@Bean
//	public javax.validation.Validator validatorFactoryBean() {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		return factory.getValidator();
//	}
//	@Bean
//	public javax.validation.Validator localValidatorFactoryBean() {
//	   return new LocalValidatorFactoryBean();
//	}
}
