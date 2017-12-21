package com.Admin.bean;

import com.Brahmalingeshwara.kanajartemple.TransactionEnum;
import com.Brahmalingeshwara.kanajartemple.TypeEnum;

public class BankAccountEntry {
	
	private Integer id;
	private Integer bankAccountId;
	private Integer bankAccountEntryId;
	private Double amount;	
	private TypeEnum type;
	private TransactionEnum transaction;
	private String chequeOrRefNo;
	private String transactionDate;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(Integer bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public Integer getBankAccountEntryId() {
		return bankAccountEntryId;
	}
	public void setBankAccountEntryId(Integer bankAccountEntryId) {
		this.bankAccountEntryId = bankAccountEntryId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public TransactionEnum getTransaction() {
		return transaction;
	}
	public void setTransaction(TransactionEnum transaction) {
		this.transaction = transaction;
	}
	public String getChequeOrRefNo() {
		return chequeOrRefNo;
	}
	public void setChequeOrRefNo(String chequeOrRefNo) {
		this.chequeOrRefNo = chequeOrRefNo;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
