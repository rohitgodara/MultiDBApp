package com.multidb.order.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private BigDecimal amount;
	private String Type;

	public Wallet() {
	}

	public Wallet(BigDecimal amount, String type) {
		super();
		this.amount = amount;
		Type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}
