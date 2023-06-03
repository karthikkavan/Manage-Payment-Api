package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ak.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query("from Payment where name=:name")
	 public List<Payment> searchPaymentByName(String name);
}
