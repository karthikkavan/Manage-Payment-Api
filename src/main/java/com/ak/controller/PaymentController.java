package com.ak.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.entity.Payment;
import com.ak.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PaymentController {

private Logger log=LoggerFactory.getLogger(PaymentController.class);	
	
	@Autowired
	private PaymentService paymentService;
	
	@Operation(summary = "create payment")
	@PostMapping("/payment")
	public ResponseEntity<String> createPayments(@RequestBody Payment payment) {
		
		log.info("begging of the create payments()");
		String msg=paymentService.createPayment(payment);
		log.info("end of the create payments()");
		return new ResponseEntity<>(msg,HttpStatus.CREATED);		
	}
	
	@Operation(summary = "update the payment")
	@PutMapping("/payment/{id}")
	public ResponseEntity<String> modifyPayment(@PathVariable Long id, @RequestBody Payment payment) {
		String msg=paymentService.updatePayment(id, payment);
		return new ResponseEntity<>(msg, HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "Delete payment by Id")
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<HttpStatus> deleteDepartmentByID(@PathVariable Long id){
		paymentService.deletedPaymentById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
	@Operation(summary = "get payment by Id")
	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		Payment payment=paymentService.getPaymentById(id);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
	
	@Operation(summary = "get all payments")
	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> findAllPayment(){
		List<Payment> list=paymentService.fetchAllPayment();
		return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
	}
	
	@Operation(summary = "Search payment by name")
	@GetMapping("/payments/{name}")
	public ResponseEntity<List<Payment>> searchPaymentByName(@PathVariable String name){
	   List<Payment> listName=paymentService.searchPaymentByName(name);
	   return new ResponseEntity<List<Payment>>(listName,HttpStatus.OK);
     }
}
