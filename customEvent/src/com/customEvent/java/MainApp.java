package com.customEvent.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		 WithdrawlEventPublisher publisher = (WithdrawlEventPublisher) context.getBean("customEventPublisher");
		BankAccount acc1 = new SavingsAccount(101, "Gaurav", 2000000);
		double balance=acc1.withdraw(20000);
		publisher.publish(balance);
	}

}
