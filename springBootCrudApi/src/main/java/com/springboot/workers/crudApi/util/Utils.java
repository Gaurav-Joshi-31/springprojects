package com.springboot.workers.crudApi.util;

import java.util.Date;

public class Utils {
public static String getCurrentTimestamp() {
	return new Date().toString();
}
}
