package org.spring.demo.ioc.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring-config.xml");
		ComplexObject complexObject = (ComplexObject) application.getBean("complexObject");
		Properties properties = complexObject.getAdminEmails();
		Iterator<Entry<Object, Object>> it = properties.entrySet().iterator();

		// 遍历Properties
		System.out.println("Properties:");
		while (it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		// 遍历List
		System.out.println("List:");
		List list = complexObject.getSomeList();
		for (Object o : list)
			System.out.println(o);

		// 遍历Map
		System.out.println("Map:");
		Map map = complexObject.getSomeMap();
		Iterator<Entry<Object, Object>> itMap = map.entrySet().iterator();
		while (itMap.hasNext()) {
			Entry<Object, Object> entry = itMap.next();
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}

		ComplexObject child = (ComplexObject) application.getBean("child");
		Properties childProperties = child.getAdminEmails();
		Iterator<Entry<Object, Object>> itChild = childProperties.entrySet().iterator();
		// 遍历Properties
		System.out.println("child Properties:");
		while (itChild.hasNext()) {
			Entry<Object, Object> entry = itChild.next();
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
		//两个类不是同一个实例
		System.out.println("parent="+complexObject);
		System.out.println("child="+child);
		
		//强类型集合,Spring自动将类型转为Float
		Map<String, Float>  accounts = child.getAccounts();
		Iterator<Entry<String, Float>> accountsMap = accounts.entrySet().iterator();
		while (accountsMap.hasNext()) {
			Entry<String, Float> entry = accountsMap.next();
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
	}
}
