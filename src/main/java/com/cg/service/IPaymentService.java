package com.cg.service;

import java.util.List;

import com.cg.entity.Payment;

public interface IPaymentService {
	
	public String createPayment(Payment payment);
	public String updatePayment(Payment payment);
	public Payment deletedPaymentById(Long pamentId);
	public Payment getPaymentByPaymentId(Long pamentId);
	public List<Payment> fetchAllPayment();
}
