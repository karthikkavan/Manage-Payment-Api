package com.ak.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment_Tbl")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "account_Id")
	private Long accountId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "account_Number")
	private Long accountNumber;
	
	@Column(name = "ifsc_Code")
	private String ifscCode;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}
	
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setPamentId(Long id) {
		this.id = id;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Payment(Long id, Long accountId, String name, Long accountNumber, String ifscCode, Double amount,
			Date date) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.amount = amount;
		this.date = date;
	}
	public Payment() {
}
	@Override
	public String toString() {
		return "Payment [pamentId=" + id + ", accountId=" + accountId + ", Name=" + name + ", accountNumber="
				+ accountNumber + ", ifscCode=" + ifscCode + ", amount=" + amount + ", date=" + date + "]";
	}
}
	