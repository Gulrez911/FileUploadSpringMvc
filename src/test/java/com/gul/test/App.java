package com.gul.test;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.gul.config.AppConfig;

public class App {

	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Main method called");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();
	}
}
