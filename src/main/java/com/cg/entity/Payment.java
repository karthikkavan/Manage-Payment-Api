package com.cg.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentId;
	private Long accountId;
	private String Name;
	private Long accountNumber;
	private String ifscCode;
	private Double amount;
	private Date date;
	private boolean deleted;
	
	
	public boolean isDeleted() {
		return deleted;
	}
	
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getPamentId() {
		return paymentId;
	}
	public void setPamentId(Long pamentId) {
		this.paymentId = pamentId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Payment(Long paymentId, Long accountId, String name, Long accountNumber, String ifscCode, Double amount,
			Date date) {
		super();
		this.paymentId = paymentId;
		this.accountId = accountId;
		Name = name;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.amount = amount;
		this.date = date;
	}
	public Payment() {
}
	@Override
	public String toString() {
		return "Payment [pamentId=" + paymentId + ", accountId=" + accountId + ", Name=" + Name + ", accountNumber="
				+ accountNumber + ", ifscCode=" + ifscCode + ", amount=" + amount + ", date=" + date + "]";
	}
}
	
