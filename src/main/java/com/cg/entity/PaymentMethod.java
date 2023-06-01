package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_Method")
public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer paymentMethodId;
	private String paymentethodType;
	private String status="Active";
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getPaymentethodType() {
		return paymentethodType;
	}
	public void setPaymentethodType(String paymentethodType) {
		this.paymentethodType = paymentethodType;
	}
	
	public PaymentMethod(Integer paymentMethodId, String paymentethodType, String status) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.paymentethodType = paymentethodType;
		this.status = status;
	}
	public PaymentMethod() {
		
	}
	@Override
	public String toString() {
		return "PaymentMethod [paymentMethodId=" + paymentMethodId + ", paymentethodType=" + paymentethodType
				+ ", status=" + status + "]";
	}
	
	
}
