package com.cm.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.emp.bean.TaxDeductionResponse;
import com.cm.emp.model.Employee;
import com.cm.emp.service.IEmployeeService;
import com.cm.emp.util.Validation;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final IEmployeeService employeeService;
	private final Logger logger;
	private final Validation validate;

	public EmployeeController(IEmployeeService employeeService, Logger logger,Validation validate) {
		this.employeeService = employeeService;
		this.logger = logger;
		this.validate=validate;
	}
	/**
	 * 
	 * @param employee required for new employee created
	 * @return return success or failed status
	 */

	@PostMapping(value = "newEmployeeCreated")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		logger.info("Inside EmployeeController saveEmployee method for save employee");
		try {
			validate.validateEmployee(employee);
			employeeService.saveEmployee(employee);
			logger.info("Employee saved successfully");
			return ResponseEntity.ok("Employee saved successfully");
		} catch (IllegalArgumentException e) {
			logger.error("Exception in save method for IlligalArgumentException "+e.toString());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			logger.error("Exception in save method for "+e.toString());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("/tax-deductions-all-employee")
    public ResponseEntity<?> getTaxDeductionsAllEmp() {
		try {
        List<TaxDeductionResponse> responses = employeeService.getTaxDeductionsForCurrentFinancialYear();
        return ResponseEntity.ok(responses);
		}
		catch (Exception e) {
			logger.error("Exception in getTaxDeductionsAllEmp method for "+e.toString());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
	
	

}
