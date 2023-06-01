package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import com.cg.entity.Payment;
import com.cg.repository.PaymentRepo;

@SpringBootTest
class PaymentServiceImplTest {

	@Mock
	private PaymentRepo paymentRepo;
	
	@InjectMocks
	private PaymentServiceImpl paymentService;

	@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void fetchAllPaymentTest() {
		Date date=new Date();
		Payment payment=new Payment(10l,3456l,"karthik",12345l,"IFSC123",10000.14 , date);
		Payment payment1=new Payment(11l,3456l,"raja",123456l,"IFSC456",11000.14 , date);
		
		List<Payment> list=new ArrayList<>();
		list.add(payment1);
		list.add(payment1);
		//CurrentDateTimeProvider mockDateProvider = ((Mockito) mockitoSession()).mock(CurrentDateTimeProvider.class);
		Mockito.when(paymentRepo.findAll()).thenReturn(list);
		List<Payment> result=paymentService.fetchAllPayment();
		assertEquals(2, list.size());
	
}
}
