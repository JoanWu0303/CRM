package com.joan.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@Column(name="email")
	@NotNull(message="is required")
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message=" Please enter a correct email format")
	private String email;
	
	@Column(name="phone")
	@NotNull(message="is required")
	@Pattern(regexp = "^(\\d{3}[- ]?){2}\\d{4}$", message="Please enter correct phone number")
	private String phoneNum;

	//no-args constructor
	public Customer() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNum=" + phoneNum + "]";
	}	
}
