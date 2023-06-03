package com.ak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.entity.Payment;
import com.ak.entity.PaymentNotFountException;
import com.ak.repository.PaymentRepository;

@Service
public class PaymentService {
	

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public String createPayment(Payment payment) {
		paymentRepository.save(payment);
		return "payment created sucessfully";
	}

	
	public String updatePayment(Long id,Payment payment) {
		Payment updatePayment=paymentRepository.findById(id).orElseThrow(()->new PaymentNotFountException("Payment id not nound"+ id ));
		updatePayment.setAccountId(payment.getAccountId());
		updatePayment.setAccountNumber(payment.getAccountNumber());
		updatePayment.setAmount(payment.getAmount());
		updatePayment.setDate(payment.getDate());
		updatePayment.setIfscCode(payment.getIfscCode());
		updatePayment.setName(payment.getName());
		updatePayment.setStatus(payment.isStatus());
		paymentRepository.save(updatePayment);
		return "payment updated";
		
	}

	public Payment deletedPaymentById(Long pamentId) {
		Payment delete=paymentRepository.findById(pamentId).orElseThrow(()-> new PaymentNotFountException("PaymentId Not found"));
		delete.setStatus(false);
		
		if(delete.isStatus()==true) {
		return paymentRepository.save(delete);
		}
		else			
		throw new PaymentNotFountException("payment id not found");
		
	
	}

	public Payment getPaymentById(Long id) {
					
		Payment payment= paymentRepository.findById(id).orElseThrow(()-> new PaymentNotFountException("PaymentId Not found"));
		
		if(payment.isStatus()==false) {
		throw new PaymentNotFountException("payment id not found");
		}
		return payment;
	}
	
	public List<Payment> fetchAllPayment() {
		List<Payment> list=paymentRepository.findAll();
		return list;
	}
	public List<Payment> searchPaymentByName(String name){
		List<Payment> nameList=paymentRepository.searchPaymentByName(name);
		return nameList;
	}

}
