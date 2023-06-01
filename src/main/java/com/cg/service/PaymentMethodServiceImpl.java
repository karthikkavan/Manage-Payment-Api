package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.PaymentMethod;
import com.cg.repository.PaymentMethodRepository;

@Service
public class PaymentMethodServiceImpl implements IPaymentMethod {

	@Autowired
	private PaymentMethodRepository paymentMethodRepo;
	@Override
	public String addPayment(PaymentMethod paymentMethod) {
		paymentMethodRepo.save(paymentMethod);
		return "Payment method saved successfully";
	}
	@Override
	public List<PaymentMethod> fetchAllPaymentMethod() {
		List<PaymentMethod> list= paymentMethodRepo.findAll();
		return list;
	}

}
