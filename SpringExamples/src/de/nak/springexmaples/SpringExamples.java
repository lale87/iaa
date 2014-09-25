package de.nak.springexmaples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExamples {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring-config.xml");
		
		ExampleBean exampleBean = 
				(ExampleBean) context.getBean("exampleBean");
		
		System.out.println(exampleBean.getText());
	}

}
