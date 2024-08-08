package com.cm.emp.service;

import java.util.List;

import com.cm.emp.bean.TaxDeductionResponse;
import com.cm.emp.model.Employee;

public interface IEmployeeService {

	 public Employee saveEmployee(Employee employee);
	 public List<Employee> getAllEmployees();
	 public Employee getEmployeeById(String employeeId);
	 public List<TaxDeductionResponse> getTaxDeductionsForCurrentFinancialYear();
}
