package org.spring.demo.ioc.nullvalue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring-config.xml");
		ExampleBean eb = (ExampleBean) application.getBean("exampleBean");
		System.out.println(eb.getEmail());
		System.out.println(eb.getAddress());
		ExampleBean classic = (ExampleBean) application.getBean("classic");
		System.out.println(classic.getEmail());
		ExampleBean p_namespace = (ExampleBean) application.getBean("p-namespace");
		System.out.println(p_namespace.getEmail());
    }
}
