package com.customEvent.java;

import java.sql.Timestamp;

import org.springframework.context.ApplicationEvent;

public class WithdrawlEvent extends ApplicationEvent {
	double accBalance;

	public WithdrawlEvent(Object source, double accBalance) {
		super(source);
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "money has been withdrawn from your account" + "\n" + "Remaining acc Balance =" + this.accBalance
				+ "\n"+"Timestamp: "+new Timestamp(System.currentTimeMillis());
	}

}
