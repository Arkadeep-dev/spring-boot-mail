package com.employee.api.service;


import com.employee.api.entity.Employee;

/**
 * interface for email service class
 * @author ArkadeepD
 * 
 */
public interface EmailServiceable {
		
	public void sendEmail(Employee employee);
}
