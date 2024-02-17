package org.makerminds.javaweb.finalexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FinalExamApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(FinalExamApplication.class, args);
	
	for(String bean: applicationContext.getBeanDefinitionNames()) {
		System.out.println(bean);
	}
 }
}
