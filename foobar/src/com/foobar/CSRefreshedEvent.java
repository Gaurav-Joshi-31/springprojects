package com.foobar;



import java.sql.Timestamp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CSRefreshedEvent implements ApplicationListener<ContextRefreshedEvent>{

	 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		 System.out.println("Context refreshed at ");
		 System.out.println(new Timestamp(System.currentTimeMillis()));
	}
	}
