package com.joan.spring.dao;

import java.util.List;

import com.joan.spring.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleterCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
}
