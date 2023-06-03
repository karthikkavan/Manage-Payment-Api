package com.ak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.entity.PaymentMethod;
import com.ak.repository.PaymentMethodRepository;

@Service
public class PaymentMethodService {

	@Autowired
	private PaymentMethodRepository paymentMethodRepo;

	public String addPayment(PaymentMethod paymentMethod) {
		paymentMethodRepo.save(paymentMethod);
		return "Payment method saved successfully";
	}
	
	public List<PaymentMethod> fetchAllPaymentMethod() {
		List<PaymentMethod> list= paymentMethodRepo.findAll();
		return list;
	}

}
