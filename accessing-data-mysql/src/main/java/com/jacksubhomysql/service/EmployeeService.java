package com.jacksubhomysql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jacksubhomysql.employee.Employee;
import com.jacksubhomysql.exception.EmployeeNotFoundException;
import com.jacksubhomysql.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRipo;
	
	public List<Employee> getAllEmployee(){
		List<Employee> employee = new ArrayList<>();
		empRipo.findAll().forEach(employee::add);
		return employee;
	}
	
	public Optional<Employee> getEmployee(Integer empId) {
		return empRipo.findById(empId);
	}
	
	public Employee addEmployee(Employee employee) {
		return empRipo.save(employee);
	}
	
	public Employee updateEmployee(Integer empId, Map<String, String> body) {
		Employee emp = empRipo.findById(empId).orElseThrow(EmployeeNotFoundException::new);
		emp.setName(body.get("name"));
		emp.setEmail(body.get("email"));
		return empRipo.save(emp);
	}
	
	public void deleteEmployee(Integer empId) {
		empRipo.deleteById(empId);
	}

}
