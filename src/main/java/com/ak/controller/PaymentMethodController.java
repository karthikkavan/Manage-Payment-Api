package com.ak.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.entity.PaymentMethod;
import com.ak.service.PaymentMethodService;

@RestController
public class PaymentMethodController {
	
	@Autowired
	private PaymentMethodService service;

	Logger logger=LoggerFactory.getLogger(PaymentMethodController.class);
	   
	@GetMapping("/payments")
	public String getPayment() {
		return "payment received success";
	}
	
	@PostMapping("/createPaymentMethods")
	public String addPayment(@RequestBody PaymentMethod paymentMethod) {
		String paymentMethodstatus=service.addPayment(paymentMethod);
		return paymentMethodstatus;
	}
	
	@GetMapping("/allPayment-Methods")
	public List<PaymentMethod> fetchAllPaymentMethod(){		
		List<PaymentMethod> list= service.fetchAllPaymentMethod();
		return list;
	}
	

}
