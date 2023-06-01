package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Payment;
import com.cg.entity.PaymentNotFountException;
import com.cg.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements IPaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentRepo paymentRepo;
	
	@Override
	public String createPayment(Payment payment) {
		logger.info("start create payment ");
		paymentRepo.save(payment);
		logger.info("create payment completed ");
		return "payment created sucessfully";
	}

	//@Override
	public String updatePayment(Payment payment) {
		Optional<Payment> optional=paymentRepo.findById(payment.getPamentId());
		if(optional.isPresent()) {
			 paymentRepo.save(payment);
			 return "payment details are updated";
		}
		else
		{
			throw new IllegalArgumentException("payment not found");
		}
		
	}

	@Override
	public Payment deletedPaymentById(Long pamentId) {
		Payment delete=paymentRepo.findById(pamentId).orElseThrow(()-> new IllegalArgumentException("PaymentId Not found"));
		delete.setDeleted(false);
		
		if(delete.isDeleted()==false) {
			throw new IllegalArgumentException("payment id not found");
			}
		return paymentRepo.save(delete);
		
	}

	@Override
	public Payment getPaymentByPaymentId(Long pamentId) {
					
		Payment payment= paymentRepo.findById(pamentId).orElseThrow(()-> new PaymentNotFountException("PaymentId Not found"));
		
		if(payment.isDeleted()==false) {
		throw new PaymentNotFountException("payment id not found");
		}
		return payment;
	}
	@Override
	public List<Payment> fetchAllPayment() {
		List<Payment> list=paymentRepo.findAll();
		return list;
	}

}
