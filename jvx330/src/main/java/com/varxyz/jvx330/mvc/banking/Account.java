package com.varxyz.jvx330.mvc.banking;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accountType;
	private double balance;
	private Date regDate;
	
	public Account() {
		super();
	}
}
