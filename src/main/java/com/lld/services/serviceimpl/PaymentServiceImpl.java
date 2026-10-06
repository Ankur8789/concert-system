package com.lld.services.serviceimpl;

import com.lld.services.PaymentService;

public class PaymentServiceImpl implements  PaymentService{

	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount);
	}
    
}
