package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Payment;
import com.cg.service.PaymentServiceImpl;

@RestController
public class PaymentController {

	@Autowired
	private PaymentServiceImpl paymentService;
	
	@PostMapping("/payments")
	public String createPayments(@RequestBody Payment payment) {
		String msg=paymentService.createPayment(payment);
		return msg;
	}
	@PutMapping("/modify")
	public String modifyPayment(@RequestBody Payment payment) {
		String msg=paymentService.createPayment(payment);
		return msg;
	}
	
	@DeleteMapping("/delete/{pamentId}")
	public void deleteDepartmentByID(@PathVariable Long pamentId){
		paymentService.deletedPaymentById(pamentId);
		
	}
		
	@GetMapping("/find/{pamentId}")
	public Payment getPaymentById(@PathVariable Long pamentId) {
		Payment payment=paymentService.getPaymentByPaymentId(pamentId);
		return payment;
	}
	
	@GetMapping("/findAll ")
	public List<Payment> findAllPayment(){
		List<Payment> list=paymentService.fetchAllPayment();
		return list;
	}
     }
