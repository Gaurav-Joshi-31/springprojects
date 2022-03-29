package com.customEvent.java;

import org.springframework.context.ApplicationListener;

public class TransactionEventHandler implements ApplicationListener<WithdrawlEvent> {
	private void sendSMS(String message, double accBalance) {
		System.out.println(message + "\n Your remaining balance: " + accBalance);
	}

	@Override
	public void onApplicationEvent(WithdrawlEvent event) {
		sendSMS(event.message, event.accBalance);
	}

}
