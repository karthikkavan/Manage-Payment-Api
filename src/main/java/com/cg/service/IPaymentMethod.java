package com.cg.service;

import java.util.List;

import com.cg.entity.PaymentMethod;

public interface IPaymentMethod {

	public String addPayment(PaymentMethod paymentMethod) ;
	public List<PaymentMethod> fetchAllPaymentMethod();
}
