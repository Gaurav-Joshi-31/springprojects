package com.springboot.my.org.crudapi.util;

import java.util.Date;

public class Utils {
	private Utils() {
		
	}
public static String getCurrentTimeStamp() {
	return new Date().toString();
}
}
