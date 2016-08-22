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
		ExampleBean eb = application.getBean(ExampleBean.class);
		System.out.println(eb.getEmail());
		System.out.println(eb.getAddress());
    }
}
