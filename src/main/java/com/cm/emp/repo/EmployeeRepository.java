package com.cm.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
